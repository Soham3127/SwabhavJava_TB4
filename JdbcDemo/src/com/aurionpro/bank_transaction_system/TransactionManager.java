package com.aurionpro.bank_transaction_system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class TransactionManager {
    public static void deposit(int accountId, int amount) {
        if (!AccountManager.doesAccountExist(accountId)) {
            System.out.println("Account ID not found.");
            return;
        }
        if (!AccountManager.isAccountActive(accountId)) {
            System.out.println("This account is frozen. Cannot deposit.");
            return;
        }
        if (amount < 100 || amount % 100 != 0) {
            System.out.println("Amount must be at least 100 and in multiples of 100.");
            return;
        }
        try (Connection conn = DatabaseConnector.getConnection()) {
            PreparedStatement updateStmt = conn.prepareStatement("UPDATE accounts SET balance = balance + ? WHERE id = ?");
            updateStmt.setInt(1, amount);
            updateStmt.setInt(2, accountId);
            int rowsUpdated = updateStmt.executeUpdate();
            System.out.println("DEBUG: Account balance updated, rows affected: " + rowsUpdated);

            Customer c = AccountManager.getCustomer(accountId);
            if (c != null) c.setBalance(c.getBalance() + amount);

            logTransaction(accountId, "Deposit", amount);
            System.out.println("Deposit successful. New balance: Rs." + AccountManager.getCustomer(accountId).getBalance());
        } catch (SQLException e) {
            System.out.println("Deposit failed: " + e.getMessage());
        }
    }

    public static void withdraw(int accountId, int amount) {
        if (!AccountManager.doesAccountExist(accountId)) {
            System.out.println("Account ID not found.");
            return;
        }
        if (!AccountManager.isAccountActive(accountId)) {
            System.out.println("This account is frozen. Cannot withdraw.");
            return;
        }
        if (amount < 100 || amount % 100 != 0) {
            System.out.println("Amount must be at least 100 and in multiples of 100.");
            return;
        }
        try (Connection conn = DatabaseConnector.getConnection()) {
            PreparedStatement checkStmt = conn.prepareStatement("SELECT balance FROM accounts WHERE id = ?");
            checkStmt.setInt(1, accountId);
            ResultSet rs = checkStmt.executeQuery();
            if (rs.next() && rs.getInt("balance") < amount) {
                System.out.println("Insufficient balance.");
                return;
            }
            PreparedStatement updateStmt = conn.prepareStatement("UPDATE accounts SET balance = balance - ? WHERE id = ?");
            updateStmt.setInt(1, amount);
            updateStmt.setInt(2, accountId);
            int rowsUpdated = updateStmt.executeUpdate();
            System.out.println("DEBUG: Account balance updated, rows affected: " + rowsUpdated);

            Customer c = AccountManager.getCustomer(accountId);
            if (c != null) c.setBalance(c.getBalance() - amount);

            logTransaction(accountId, "Withdraw", amount);
            System.out.println("Withdrawal successful. New balance: Rs." + AccountManager.getCustomer(accountId).getBalance());
        } catch (SQLException e) {
            System.out.println("Withdrawal failed: " + e.getMessage());
        }
    }

    public static void transfer(int fromId, int toId, int amount) {
        if (!AccountManager.doesAccountExist(fromId) || !AccountManager.doesAccountExist(toId)) {
            System.out.println("One or both Account IDs do not exist.");
            return;
        }
        if (!AccountManager.isAccountActive(fromId) || !AccountManager.isAccountActive(toId)) {
            System.out.println("One or both accounts are frozen. Cannot proceed with transfer.");
            return;
        }
        if (fromId == toId) {
            System.out.println("Cannot transfer to the same account.");
            return;
        }
        if (amount <= 0) {
            System.out.println("Amount must be positive.");
            return;
        }
        try (Connection conn = DatabaseConnector.getConnection()) {
            conn.setAutoCommit(false);
            PreparedStatement checkStmt = conn.prepareStatement("SELECT balance FROM accounts WHERE id = ?");
            checkStmt.setInt(1, fromId);
            ResultSet rs = checkStmt.executeQuery();
            if (rs.next() && rs.getInt("balance") < amount) {
                System.out.println("Insufficient balance.");
                conn.rollback();
                return;
            }
            PreparedStatement deductStmt = conn.prepareStatement("UPDATE accounts SET balance = balance - ? WHERE id = ?");
            deductStmt.setInt(1, amount);
            deductStmt.setInt(2, fromId);
            int rowsDeducted = deductStmt.executeUpdate();
            System.out.println("DEBUG: Sender balance updated, rows affected: " + rowsDeducted);

            PreparedStatement addStmt = conn.prepareStatement("UPDATE accounts SET balance = balance + ? WHERE id = ?");
            addStmt.setInt(1, amount);
            addStmt.setInt(2, toId);
            int rowsAdded = addStmt.executeUpdate();
            System.out.println("DEBUG: Receiver balance updated, rows affected: " + rowsAdded);

            Customer from = AccountManager.getCustomer(fromId);
            Customer to = AccountManager.getCustomer(toId);
            if (from != null) from.setBalance(from.getBalance() - amount);
            if (to != null) to.setBalance(to.getBalance() + amount);

            logTransaction(fromId, "Transfer to " + toId, amount);
            logTransaction(toId, "Received from " + fromId, amount);

            conn.commit();
            System.out.println("Transfer successful.");
        } catch (SQLException e) {
            System.out.println("Transfer failed: " + e.getMessage());
            try (Connection conn = DatabaseConnector.getConnection()) {
                conn.rollback();
            } catch (SQLException rollbackEx) {
                System.out.println("Rollback failed: " + rollbackEx.getMessage());
            }
        } finally {
            try (Connection conn = DatabaseConnector.getConnection()) {
                conn.setAutoCommit(true);
            } catch (SQLException e) {
                System.out.println("Failed to reset auto-commit: " + e.getMessage());
            }
        }
    }

    public static void viewTransactionsByAccount(int accountId) {
        if (!AccountManager.doesAccountExist(accountId)) {
            System.out.println("\n════════════════════ Transaction History ════════════════════");
            System.out.println("Account ID not found.");
            System.out.println("═════════════════════════════════════════════════════════════");
            return;
        }
        try (Connection conn = DatabaseConnector.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM transactions WHERE account_id = ? ORDER BY timestamp DESC");
            stmt.setInt(1, accountId);
            ResultSet rs = stmt.executeQuery();
            System.out.println("\n════════════════════ Transaction History for Account ID: " + accountId + " ════════════════════");
            System.out.println("┌──────────┬─────────────────┬──────────┬─────────────────────────────┐");
            System.out.printf("│ %-8s │ %-15s │ %-8s │ %-27s │\n", "ID", "Type", "Amount", "Date");
            System.out.println("├──────────┼─────────────────┼──────────┼─────────────────────────────┤");
            boolean hasTransactions = false;
            while (rs.next()) {
                hasTransactions = true;
                System.out.printf("│ %-8d │ %-15s │ %-8d │ %-27s │\n",
                        rs.getInt("id"), rs.getString("type"), rs.getInt("amount"), rs.getTimestamp("timestamp"));
            }
            if (!hasTransactions) {
                System.out.println("│ No transactions found for this account.                           │");
            }
            System.out.println("└──────────┴─────────────────┴──────────┴─────────────────────────────┘");
            System.out.println("═══════════════════════════════════════════════════════════════════════");
        } catch (SQLException e) {
            System.out.println("Failed to retrieve transactions: " + e.getMessage());
            System.out.println("═══════════════════════════════════════════════════════════════════════");
        }
    }

    public static void viewAllTransactions() {
        try (Connection conn = DatabaseConnector.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM transactions ORDER BY timestamp DESC");
            ResultSet rs = stmt.executeQuery();
            System.out.println("\n════════════════════ All Transactions ════════════════════");
            System.out.println("┌──────────┬──────────────┬─────────────────┬──────────┬─────────────────────────────┐");
            System.out.printf("│ %-8s │ %-12s │ %-15s │ %-8s │ %-27s │\n", "ID", "Account ID", "Type", "Amount", "Date");
            System.out.println("├──────────┼──────────────┼─────────────────┼──────────┼─────────────────────────────┤");
            boolean hasTransactions = false;
            while (rs.next()) {
                hasTransactions = true;
                System.out.printf("│ %-8d │ %-12d │ %-15s │ %-8d │ %-27s │\n",
                        rs.getInt("id"), rs.getInt("account_id"), rs.getString("type"),
                        rs.getInt("amount"), rs.getTimestamp("timestamp"));
            }
            if (!hasTransactions) {
                System.out.println("│ No transactions found.                                            │");
            }
            System.out.println("└──────────┴──────────────┴─────────────────┴──────────┴─────────────────────────────┘");
            System.out.println("═══════════════════════════════════════════════════════════════════════");
        } catch (SQLException e) {
            System.out.println("Failed to retrieve transactions: " + e.getMessage());
            System.out.println("═══════════════════════════════════════════════════════════════════════");
        }
    }

    public static void logTransaction(int accountId, String type, int amount) {
        try (Connection conn = DatabaseConnector.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(
                    "INSERT INTO transactions(account_id, type, amount, timestamp) VALUES (?, ?, ?, ?)");
            stmt.setInt(1, accountId);
            stmt.setString(2, type);
            stmt.setInt(3, amount);
            stmt.setTimestamp(4, java.sql.Timestamp.valueOf(LocalDateTime.now()));
            int rowsInserted = stmt.executeUpdate();
            System.out.println("DEBUG: Transaction logged, rows inserted: " + rowsInserted);
        } catch (SQLException e) {
            System.out.println("Failed to log transaction: " + e.getMessage());
        }
    }
}