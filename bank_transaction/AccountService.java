package com.aurionpro.jdbc.bank_transaction;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AccountService {
    private final Scanner sc;

    public AccountService(Scanner sc) {
        this.sc = sc;
    }

    @SuppressWarnings("removal")
    // Adding account 
	public void addAccount() {
        try (Connection conn = DatabaseManager.getConnection()) {
            int id;
            while (true) {
                System.out.print("Enter Account ID: ");
                try {
                    id = Integer.valueOf(sc.nextLine());
                    PreparedStatement checkStmt = conn.prepareStatement("SELECT * FROM accounts WHERE id = ?");
                    checkStmt.setInt(1, id);
                    ResultSet rs = checkStmt.executeQuery();
                    if (rs.next()) {
                        System.out.println(" Account ID already exists. Try again.");
                    } else break;
                } catch (Exception e) {
                    System.out.println(" Invalid input. Please enter a whole number.");
                }
            }

            System.out.print("Enter Account Holder Name: ");
            String name = sc.nextLine();
         
            int balance;
            while (true) {
                System.out.print("Enter Initial Balance (Should be more than 1000): ");
                try {
                	balance = new Integer(sc.nextLine());

                    if (balance <= 1000) {  
                        System.out.println("Initial balance must be more than ₹1000");
                        continue;
                    }
                    break;
                } catch (Exception e) {
                    System.out.println(" Invalid input. Enter a whole number.");
                }
            }

            PreparedStatement insertStmt = conn.prepareStatement("INSERT INTO accounts (id, name, balance) VALUES (?, ?, ?)");
            insertStmt.setInt(1, id);
            insertStmt.setString(2, name);
            insertStmt.setInt(3, balance);
            int rows = insertStmt.executeUpdate();

            if (rows > 0) {
                System.out.println(" Account created successfully.");
            } else {
                System.out.println("Failed to add account.");
            }

        } catch (SQLException e) {
            System.out.println("❌ DB Error: " + e.getMessage());
        }
    }
    // View All accounts 
    public void viewAllAccounts() {
        try (Connection conn = DatabaseManager.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM accounts");
            ResultSet rs = stmt.executeQuery();

            System.out.println("+------+----------------+----------+");
            System.out.println("| ID   | Name           | Balance  |");
            System.out.println("+------+----------------+----------+");

            while (rs.next()) {
                System.out.printf("| %-4d | %-14s | ₹%-7d |\n", rs.getInt("id"), rs.getString("name"), rs.getInt("balance"));
            }

            System.out.println("+------+----------------+----------+");

        } catch (SQLException e) {
            System.out.println("❌ DB Error: " + e.getMessage());
        }
    }
    // Delete
    public void deleteAccount() {
        try (Connection conn = DatabaseManager.getConnection()) {
            System.out.print("Enter Account ID to delete: ");
            int id = Integer.valueOf(sc.nextLine());

            PreparedStatement check = conn.prepareStatement("SELECT * FROM accounts WHERE id = ?");
            check.setInt(1, id);
            ResultSet rs = check.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                int balance = rs.getInt("balance");

                PreparedStatement insertInactive = conn.prepareStatement("INSERT INTO inactive_accounts (id, name, balance) VALUES (?, ?, ?)");
                insertInactive.setInt(1, id);
                insertInactive.setString(2, name);
                insertInactive.setInt(3, balance);
                insertInactive.executeUpdate();

                PreparedStatement deleteStmt = conn.prepareStatement("DELETE FROM accounts WHERE id = ?");
                deleteStmt.setInt(1, id);
                deleteStmt.executeUpdate();

                System.out.println(" Account " + id + " deleted and archived.");
            } else {
                System.out.println(" Account not found.");
            }

        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
    // To view balance 
    public void viewBalance() {
        try (Connection conn = DatabaseManager.getConnection()) {
            System.out.print("Enter Account ID to view balance: ");
            int id = Integer.valueOf(sc.nextLine());

            PreparedStatement stmt = conn.prepareStatement("SELECT name, balance FROM accounts WHERE id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                int balance = rs.getInt("balance");
                System.out.println(" Name: " + name);
                System.out.println(" Account Balance: ₹" + balance);
            } else {
                System.out.println(" Account not found.");
            }

        } catch (Exception e) {
            System.out.println(" Error: " + e.getMessage());
        }
    }
}
