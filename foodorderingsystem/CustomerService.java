package com.foodorderingsystem;

import java.sql.*;
import java.util.Scanner;

public class CustomerService {
    private int currentCustomerId; // Store logged-in customer ID

    public void register(Scanner scanner) {
        try {
            System.out.print("\nEnter Name: ");
            String name = scanner.nextLine();
            if (name.trim().isEmpty()) {
                System.out.println("Name cannot be empty.");
                return;
            }

            String phone;
            while (true) {
                System.out.print("Enter 10-digit Phone Number: ");
                phone = scanner.nextLine();
                if (phone.matches("\\d{10}")) break;
                System.out.println("Invalid phone number. Must be 10 digits.");
            }

            String username;
            while (true) {
                System.out.print("Enter Username: ");
                username = scanner.nextLine();
                if (username.trim().isEmpty()) {
                    System.out.println("Username cannot be empty.");
                    continue;
                }
                try (Connection conn = DBConnection.getConnection();
                     PreparedStatement stmt = conn.prepareStatement("SELECT * FROM customers WHERE username = ?")) {
                    stmt.setString(1, username);
                    if (!stmt.executeQuery().next()) break;
                    System.out.println("Username already exists. Try another.");
                }
            }

            System.out.print("Enter Password: ");
            String password = scanner.nextLine();
            if (password.trim().isEmpty()) {
                System.out.println("Password cannot be empty.");
                return;
            }

            System.out.print("Enter Address: ");
            String address = scanner.nextLine();
            if (address.trim().isEmpty()) {
                System.out.println("Address cannot be empty.");
                return;
            }

            try (Connection conn = DBConnection.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(
                         "INSERT INTO customers (name, phone, address, username, password) VALUES (?, ?, ?, ?, ?)")) {
                stmt.setString(1, name);
                stmt.setString(2, phone);
                stmt.setString(3, address);
                stmt.setString(4, username);
                stmt.setString(5, password);
                int rows = stmt.executeUpdate();
                System.out.println(rows > 0 ? "Registration successful! Welcome, " + name + "." : "Registration failed.");
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    public boolean login(Scanner scanner) {
        while (true) {
            System.out.print("\nEnter Username: ");
            String username = scanner.nextLine();
            System.out.print("Enter Password: ");
            String password = scanner.nextLine();

            try (Connection conn = DBConnection.getConnection();
                 PreparedStatement stmt = conn.prepareStatement("SELECT * FROM customers WHERE username = ? AND password = ?")) {
                stmt.setString(1, username);
                stmt.setString(2, password);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    currentCustomerId = rs.getInt("id");
                    System.out.println("Welcome back, " + rs.getString("name") + "!");
                    return true;
                } else {
                    System.out.println("Invalid credentials. Try again or register first.");
                    System.out.print("Retry? (yes/no): ");
                    if (!scanner.nextLine().equalsIgnoreCase("yes")) return false;
                }
            } catch (SQLException e) {
                System.out.println("Database error: " + e.getMessage());
                return false;
            }
        }
    }

    public void viewOrderHistory() throws SQLException {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "SELECT o.order_id, o.total, o.discount_applied, o.payment_mode, o.delivery_partner, o.order_date " +
                             "FROM orders o WHERE o.customer_id = ?")) {
            stmt.setInt(1, currentCustomerId);
            ResultSet rs = stmt.executeQuery();

            System.out.println("\n------------------ ORDER HISTORY ------------------");
            System.out.printf("%-10s %-12s %-12s %-12s %-20s %-20s\n",
                    "Order ID", "Total", "Discount", "Payment Mode", "Delivery Partner", "Order Date");
            System.out.println("---------------------------------------------------------------");
            while (rs.next()) {
                System.out.printf("%-10d %-12.2f %-12.2f %-12s %-20s %-20s\n",
                        rs.getInt("order_id"), rs.getDouble("total"), rs.getDouble("discount_applied"),
                        rs.getString("payment_mode"), rs.getString("delivery_partner"), rs.getString("order_date"));
            }

            System.out.print("Enter Order ID to view details (0 to go back): ");
            Scanner scanner = new Scanner(System.in);
            int orderId;
            while (true) {
                try {
                    orderId = Integer.parseInt(scanner.nextLine());
                    if (orderId == 0) return;
                    try (PreparedStatement detailStmt = conn.prepareStatement(
                            "SELECT * FROM order_items WHERE order_id = ?")) {
                        detailStmt.setInt(1, orderId);
                        ResultSet detailRs = detailStmt.executeQuery();
                        if (detailRs.next()) {
                            System.out.println("\n------------------ ORDER ITEMS ------------------");
                            System.out.printf("%-20s %-10s %-10s\n", "Item Name", "Quantity", "Price");
                            System.out.println("---------------------------------------------");
                            do {
                                System.out.printf("%-20s %-10d %-10.2f\n",
                                        detailRs.getString("item_name"), detailRs.getInt("quantity"), detailRs.getDouble("price"));
                            } while (detailRs.next());
                            return;
                        } else {
                            System.out.println("Invalid Order ID.");
                        }
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number.");
                }
            }
        }
    }

    public int getCurrentCustomerId() {
        return currentCustomerId;
    }
}