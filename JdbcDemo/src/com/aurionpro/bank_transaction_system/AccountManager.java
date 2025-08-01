package com.aurionpro.bank_transaction_system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class AccountManager {
    private static final Map<Integer, Customer> customers = new HashMap<>();
    private static int nextAccountId = 101;

    static {
        loadCustomersFromDatabase();
    }

    private static void loadCustomersFromDatabase() {
        try (Connection conn = DatabaseConnector.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM accounts");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                customers.put(id, new Customer(
                    id,
                    rs.getString("name"),
                    rs.getInt("age"),
                    rs.getString("gender"),
                    rs.getString("phone"),
                    rs.getInt("pin"),
                    rs.getInt("balance"),
                    rs.getBoolean("is_active"),
                    rs.getInt("wrong_attempts")
                ));
                if (id >= nextAccountId && id <= 999) {
                    nextAccountId = id + 1;
                }
            }
            if (nextAccountId > 999) {
                System.out.println("Warning: Maximum account ID (999) reached.");
            }
        } catch (SQLException e) {
            System.out.println("Failed to load customers from database: " + e.getMessage());
        }
    }

    public static void createAccount() {
        System.out.println("\n════════════════════ Create New Account ════════════════════");
        int accountId;
        while (true) {
            accountId = InputUtils.getValidatedIntInRange("Enter desired Account ID", 101, 999);
            if (!customers.containsKey(accountId)) break;
            System.out.println("Account ID already exists. Try a different one.");
        }
        String name = InputUtils.getNonEmptyString("Enter your name: ");
        int age = InputUtils.getValidatedIntInRange("Enter your age", 18, 60);
        String gender = InputUtils.getValidatedGender("Enter Gender");
        String phone = InputUtils.getValidatedPhone("Enter your phone number: ");
        int pin = InputUtils.readMaskedPIN("Set your 4-digit PIN: ");
        int initialBalance = InputUtils.getValidatedAmount("Enter initial balance (min 500, multiple of 100): ", 100, 500);

        createAccount(accountId, name, age, gender, phone, pin, initialBalance);
    }

    public static void createAccount(int accountId, String name, int age, String gender, String phone, int pin, int initialBalance) {
        if (accountId < 101 || accountId > 999) {
            System.out.println("Account ID must be between 101 and 999.");
            return;
        }
        if (customers.containsKey(accountId)) {
            System.out.println("Account ID " + accountId + " already exists.");
            return;
        }
        try (Connection conn = DatabaseConnector.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(
                    "INSERT INTO accounts(id, name, age, gender, phone, pin, balance, is_active, wrong_attempts) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setInt(1, accountId);
            stmt.setString(2, name);
            stmt.setInt(3, age);
            stmt.setString(4, gender);
            stmt.setString(5, phone);
            stmt.setInt(6, pin);
            stmt.setInt(7, initialBalance);
            stmt.setBoolean(8, true);
            stmt.setInt(9, 0);
            stmt.executeUpdate();

            customers.put(accountId, new Customer(accountId, name, age, gender, phone, pin, initialBalance, true, 0));
            if (accountId >= nextAccountId && accountId <= 999) {
                nextAccountId = accountId + 1;
            }
            System.out.println("Account created successfully with Account ID: " + accountId);
            System.out.println("═══════════════════════════════════════════════════════════");
        } catch (SQLException e) {
            System.out.println("Failed to create account: " + e.getMessage());
        }
    }

    public static boolean doesAccountExist(int id) {
        return customers.containsKey(id);
    }

    public static boolean isAccountActive(int id) {
        Customer c = customers.get(id);
        return c != null && c.isActive();
    }

    public static void viewAllAccounts() {
        System.out.println("\n════════════════════ All Accounts ════════════════════");
        System.out.println("┌──────────┬─────────────────┬──────────┬──────────┬─────────────────┬──────────┐");
        System.out.printf("│ %-8s │ %-15s │ %-8s │ %-8s │ %-15s │ %-8s │\n", "ID", "Name", "Age", "Gender", "Phone", "Status");
        System.out.println("├──────────┼─────────────────┼──────────┼──────────┼─────────────────┼──────────┤");
        if (customers.isEmpty()) {
            System.out.println("│ No accounts found.                                                  │");
        } else {
            for (Customer c : customers.values()) {
                String status = c.isActive() ? "Active" : "Inactive";
                String gender = c.getGender() != null ? c.getGender() : "N/A";
                System.out.printf("│ %-8d │ %-15s │ %-8d │ %-8s │ %-15s │ %-8s │\n",
                        c.getId(), c.getName(), c.getAge(), gender, c.getPhone(), status);
            }
        }
        System.out.println("└──────────┴─────────────────┴──────────┴──────────┴─────────────────┴──────────┘");
        System.out.println("══════════════════════════════════════════════════════");
    }

    public static void displayActiveAccounts() {
        System.out.println("\n════════════════════ Active Accounts ════════════════════");
        System.out.println("┌──────────┬─────────────────┬──────────┬──────────┬─────────────────┐");
        System.out.printf("│ %-8s │ %-15s │ %-8s │ %-8s │ %-15s │\n", "ID", "Name", "Age", "Gender", "Phone");
        System.out.println("├──────────┼─────────────────┼──────────┼──────────┼─────────────────┤");
        boolean hasActiveAccounts = false;
        for (Customer c : customers.values()) {
            if (c.isActive()) {
                hasActiveAccounts = true;
                String gender = c.getGender() != null ? c.getGender() : "N/A";
                System.out.printf("│ %-8d │ %-15s │ %-8d │ %-8s │ %-15s │\n",
                        c.getId(), c.getName(), c.getAge(), gender, c.getPhone());
            }
        }
        if (!hasActiveAccounts) {
            System.out.println("│ No active accounts found.                                           │");
        }
        System.out.println("└──────────┴─────────────────┴──────────┴──────────┴─────────────────┘");
        System.out.println("═════════════════════════════════════════════════════════");
    }

    public static void deleteAccount(int id) {
        Customer c = customers.get(id);
        if (c != null) {
            c.setActive(false);
            try (Connection conn = DatabaseConnector.getConnection()) {
                PreparedStatement stmt = conn.prepareStatement("UPDATE accounts SET is_active = ? WHERE id = ?");
                stmt.setBoolean(1, false);
                stmt.setInt(2, id);
                stmt.executeUpdate();
                System.out.println("Account frozen (deleted).");
            } catch (SQLException e) {
                System.out.println("Failed to delete account: " + e.getMessage());
            }
        } else {
            System.out.println("Account not found.");
        }
        System.out.println("═════════════════════════════════════════════════════════");
    }

    public static void updateAccountDetails(int id) {
        Customer c = customers.get(id);
        if (c == null || !c.isActive()) {
            System.out.println("\n════════════════════ Update Account ════════════════════");
            System.out.println("Cannot update. Account not found or is inactive.");
            System.out.println("═════════════════════════════════════════════════════════");
            return;
        }
        System.out.println("\n════════════════════ Update Account Info for ID: " + id + " ════════════════════");
        System.out.println("Current Name: " + c.getName());
        String name = InputUtils.getOptionalString("Enter new name (press Enter to skip): ", c.getName());
        
        System.out.println("Current Age: " + c.getAge());
        int age = InputUtils.getOptionalIntInRange("Enter new age (18-60, press Enter to skip): ", 18, 60, c.getAge());
        
        System.out.println("Current Phone: " + c.getPhone());
        String phone = InputUtils.getOptionalPhone("Enter new phone number (press Enter to skip): ", c.getPhone());
        
        String genderDisplay = c.getGender() != null ? c.getGender() : "N/A";
        System.out.println("Current Gender: " + genderDisplay);
        String gender = InputUtils.getOptionalGender("Enter Gender (M/F, press Enter to skip): ", c.getGender() != null ? c.getGender() : "Male");

        c.setName(name);
        c.setAge(age);
        c.setPhone(phone);
        c.setGender(gender);
        try (Connection conn = DatabaseConnector.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(
                    "UPDATE accounts SET name = ?, age = ?, phone = ?, gender = ? WHERE id = ?");
            stmt.setString(1, name);
            stmt.setInt(2, age);
            stmt.setString(3, phone);
            stmt.setString(4, gender);
            stmt.setInt(5, id);
            stmt.executeUpdate();
            System.out.println("Account details updated.");
        } catch (SQLException e) {
            System.out.println("Failed to update account: " + e.getMessage());
        }
        System.out.println("═════════════════════════════════════════════════════════");
    }

    public static void changePin(int id) {
        Customer c = customers.get(id);
        if (c == null || !c.isActive()) {
            System.out.println("\n════════════════════ Change PIN ════════════════════");
            System.out.println("Account not found or inactive.");
            System.out.println("════════════════════════════════════════════════════");
            return;
        }
        System.out.println("\n════════════════════ Change PIN for ID: " + id + " ════════════════════");
        int currentPin = InputUtils.readMaskedPIN("Enter current PIN: ");
        if (c.getPin() != currentPin) {
            System.out.println("Incorrect PIN.");
            incrementWrongAttempts(id);
            System.out.println("════════════════════════════════════════════════════");
            return;
        }
        int newPin;
        while (true) {
            newPin = InputUtils.readMaskedPIN("Enter new 4-digit PIN: ");
            if (newPin != currentPin) break;
            System.out.println("New PIN cannot be the same as the current PIN.");
        }
        c.setPin(newPin);
        try (Connection conn = DatabaseConnector.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("UPDATE accounts SET pin = ? WHERE id = ?");
            stmt.setInt(1, newPin);
            stmt.setInt(2, id);
            stmt.executeUpdate();
            System.out.println("PIN updated successfully.");
        } catch (SQLException e) {
            System.out.println("Failed to update PIN: " + e.getMessage());
        }
        System.out.println("════════════════════════════════════════════════════");
    }

    public static boolean validatePin(int id, int enteredPin) {
        Customer c = customers.get(id);
        return c != null && c.isActive() && c.getPin() == enteredPin;
    }

    public static void incrementWrongAttempts(int id) {
        Customer c = customers.get(id);
        if (c == null) return;
        int attempts = c.getWrongAttempts() + 1;
        c.setWrongAttempts(attempts);
        try (Connection conn = DatabaseConnector.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("UPDATE accounts SET wrong_attempts = ? WHERE id = ?");
            stmt.setInt(1, attempts);
            stmt.setInt(2, id);
            stmt.executeUpdate();
            if (attempts >= 5) {
                c.setActive(false);
                stmt = conn.prepareStatement("UPDATE accounts SET is_active = ? WHERE id = ?");
                stmt.setBoolean(1, false);
                stmt.setInt(2, id);
                stmt.executeUpdate();
                System.out.println("Account frozen due to 5 wrong attempts. Contact manager.");
            }
        } catch (SQLException e) {
            System.out.println("Failed to update attempts: " + e.getMessage());
        }
    }

    public static void resetWrongAttempts(int id) {
        Customer c = customers.get(id);
        if (c != null) {
            c.setWrongAttempts(0);
            try (Connection conn = DatabaseConnector.getConnection()) {
                PreparedStatement stmt = conn.prepareStatement("UPDATE accounts SET wrong_attempts = ? WHERE id = ?");
                stmt.setInt(1, 0);
                stmt.setInt(2, id);
                stmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Failed to reset attempts: " + e.getMessage());
            }
        }
    }

    public static void freezeAccount(int id) {
        Customer c = customers.get(id);
        if (c != null) {
            c.setActive(false);
            try (Connection conn = DatabaseConnector.getConnection()) {
                PreparedStatement stmt = conn.prepareStatement("UPDATE accounts SET is_active = ? WHERE id = ?");
                stmt.setBoolean(1, false);
                stmt.setInt(2, id);
                stmt.executeUpdate();
                System.out.println("Account frozen (deleted).");
            } catch (SQLException e) {
                System.out.println("Failed to freeze account: " + e.getMessage());
            }
        } else {
            System.out.println("Account not found.");
        }
        System.out.println("═════════════════════════════════════════════════════════");
    }

    public static void unfreezeAccount(int id) {
        Customer c = customers.get(id);
        if (c != null) {
            c.setActive(true);
            try (Connection conn = DatabaseConnector.getConnection()) {
                PreparedStatement stmt = conn.prepareStatement("UPDATE accounts SET is_active = ? WHERE id = ?");
                stmt.setBoolean(1, true);
                stmt.setInt(2, id);
                stmt.executeUpdate();
                System.out.println("Account unfrozen successfully.");
            } catch (SQLException e) {
                System.out.println("Failed to unfreeze account: " + e.getMessage());
            }
        } else {
            System.out.println("Account not found.");
        }
        System.out.println("═════════════════════════════════════════════════════════");
    }

    public static void displayInactiveAccounts() {
        System.out.println("\n════════════════════ Inactive Accounts ════════════════════");
        System.out.println("┌──────────┬─────────────────┬─────────────────┬──────────┐");
        System.out.printf("│ %-8s │ %-15s │ %-15s │ %-8s │\n", "ID", "Name", "Phone", "Status");
        System.out.println("├──────────┼─────────────────┼─────────────────┼──────────┤");
        boolean hasInactiveAccounts = false;
        for (Customer c : customers.values()) {
            if (!c.isActive()) {
                hasInactiveAccounts = true;
                System.out.printf("│ %-8d │ %-15s │ %-15s │ %-8s │\n",
                        c.getId(), c.getName(), c.getPhone(), "Inactive");
            }
        }
        if (!hasInactiveAccounts) {
            System.out.println("│ No inactive accounts found.                                         │");
        }
        System.out.println("└──────────┴─────────────────┴─────────────────┴──────────┘");
        System.out.println("═══════════════════════════════════════════════════════════");
    }

    public static Customer getCustomer(int id) {
        return customers.get(id);
    }

    public static boolean checkAccountExists(int id) {
        return doesAccountExist(id);
    }

    public static void showBalance(int id) {
        Customer c = customers.get(id);
        if (c == null) {
            System.out.println("\n════════════════════ Balance Inquiry ════════════════════");
            System.out.println("Account not found.");
        } else if (!c.isActive()) {
            System.out.println("\n════════════════════ Balance Inquiry ════════════════════");
            System.out.println("Account is inactive.");
        } else {
            System.out.println("\n════════════════════ Balance Inquiry ════════════════════");
            System.out.println("Current Balance for Account ID " + id + ": Rs." + c.getBalance());
        }
        System.out.println("═════════════════════════════════════════════════════════");
    }

    public static boolean validateAdminCredentials(String username, String password) {
        try (Connection conn = DatabaseConnector.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM admin WHERE username = ? AND password = ?");
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.out.println("Failed to validate admin credentials: " + e.getMessage());
            return false;
        }
    }
}