package com.aurionpro.jdbc.bank_transaction;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class TransactionService {
    private final Scanner sc;

    public TransactionService(Scanner scanner) {
        this.sc = scanner;
    }

    public void depositMoney() {
        int id = getValidId("Enter Account ID: ", false);
        double amount = getValidAmount("Enter Amount to Deposit (multiple of 10): ", 10);

        try (Connection conn = DatabaseManager.getConnection()) {
            updateBalance(conn, id, amount);
            recordTransaction(conn, null, id, amount, "Deposit");
            System.out.println(" ₹" + amount + " deposited to Account " + id);
        } catch (SQLException e) {
            System.out.println(" Error: " + e.getMessage());
        }
    }

    public void withdrawMoney() {
        int id = getValidId("Enter Account ID: ", false);

        
        try (Connection conn = DatabaseManager.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("SELECT balance FROM accounts WHERE id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                double currentBalance = rs.getDouble("balance");
                System.out.println(" Current Balance: ₹" + currentBalance);
            } else {
                System.out.println(" Account not found.");
                return;
            }
        } catch (SQLException e) {
            System.out.println(" Error: " + e.getMessage());
            return;
        }

        double amount = getValidAmount("Enter Amount to Withdraw (multiple of 100): ", 100);

        try (Connection conn = DatabaseManager.getConnection()) {
            if (!hasSufficientBalance(conn, id, amount)) {
                System.out.println(" Insufficient balance.");
                return;
            }
            updateBalance(conn, id, -amount);
            recordTransaction(conn, id, null, amount, "Withdraw");
            System.out.println(" ₹" + amount + " withdrawn from Account " + id);
        } catch (SQLException e) {
            System.out.println(" Error: " + e.getMessage());
        }
    }

    public void transferMoney() {
        int sender = getValidId("Enter Sender ID: ", false);
        int receiver = getValidId("Enter Receiver ID: ", false);
        if (sender == receiver) {
            System.out.println(" Sender & Receiver must be different.");
            return;
        }
        double amount = getValidAmount("Enter Amount to Transfer: ", 1);

        try (Connection conn = DatabaseManager.getConnection()) {
            conn.setAutoCommit(false);

            if (!hasSufficientBalance(conn, sender, amount)) {
                System.out.println(" Insufficient balance.");
                return;
            }

            updateBalance(conn, sender, -amount);
            updateBalance(conn, receiver, amount);
            recordTransaction(conn, sender, receiver, amount, "Transfer");

            conn.commit();
            System.out.println(" ₹" + amount + " transferred from Account " + sender + " to " + receiver);
        } catch (SQLException e) {
            System.out.println(" Error: " + e.getMessage());
        }
    }

    public void viewTransactionHistory() {
        int id = getValidId("Enter Account ID to view history: ", false);
        String query = """
            SELECT transaction_id, sender_id, receiver_id, amount, type
            FROM transactions
            WHERE sender_id = ? OR receiver_id = ?
            ORDER BY transaction_id
        """;

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            stmt.setInt(2, id);
            ResultSet rs = stmt.executeQuery();

            System.out.println("\n=== Transaction History ===");
            System.out.printf("%-10s %-10s %-10s %-10s %-10s\n",
                    "Transaction ID", "Sender", "Receiver", "Amount", "Type");
            System.out.println("-------------------------------------------------------------");

            while (rs.next()) {
                System.out.printf("%-10d %-10s %-10s %-10.2f %-10s\n",
                        rs.getInt("transaction_id"),
                        rs.getString("sender_id"),
                        rs.getString("receiver_id"),
                        rs.getDouble("amount"),
                        rs.getString("type"));
            }
        } catch (SQLException e) {
            System.out.println(" Error: " + e.getMessage());
        }
    }

   

    private int getValidId(String prompt, boolean mustBeNew) {
        while (true) {
            System.out.print(prompt);
            try {
                int id = Integer.valueOf(sc.nextLine());
                try (Connection conn = DatabaseManager.getConnection();
                     PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) FROM accounts WHERE id = ?")) {
                    stmt.setInt(1, id);
                    ResultSet rs = stmt.executeQuery();
                    if (rs.next()) {
                        boolean exists = rs.getInt(1) > 0;
                        if (mustBeNew && exists) {
                            System.out.println(" ID already exists. Enter a new one.");
                        } else if (!mustBeNew && !exists) {
                            System.out.println(" ID does not exist.");
                        } else {
                            return id;
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println(" Invalid input. Please enter a valid number.");
            }
        }
    }

    private double getValidAmount(String prompt, int multiple) {
        while (true) {
            System.out.print(prompt);
            try {
                double amt = Double.valueOf(sc.nextLine());
                if (amt <= 0 || ((int) amt) % multiple != 0) {
                    System.out.println(" Must be multiple of " + multiple);
                    continue;
                }
                return amt;
            } catch (Exception e) {
                System.out.println(" Invalid input.");
            }
        }
    }

    private boolean hasSufficientBalance(Connection conn, int id, double amount) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement("SELECT balance FROM accounts WHERE id = ?")) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            return rs.next() && rs.getDouble("balance") >= amount;
        }
    }

    private void updateBalance(Connection conn, int id, double amt) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement("UPDATE accounts SET balance = balance + ? WHERE id = ?")) {
            stmt.setDouble(1, amt);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        }
    }

    private void recordTransaction(Connection conn, Integer sender, Integer receiver, double amt, String type) throws SQLException {
        String query = "INSERT INTO transactions (sender_id, receiver_id, amount, type) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            if (sender != null) stmt.setInt(1, sender); else stmt.setNull(1, Types.INTEGER);
            if (receiver != null) stmt.setInt(2, receiver); else stmt.setNull(2, Types.INTEGER);
            stmt.setDouble(3, amt);
            stmt.setString(4, type);
            stmt.executeUpdate();
        }
    }
}
