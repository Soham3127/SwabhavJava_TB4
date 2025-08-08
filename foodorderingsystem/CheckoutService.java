package com.foodorderingsystem;

import java.sql.*;
import java.util.*;

public class CheckoutService {
    public static void proceedToCheckout(Scanner scanner, CustomerService customerService) {
        Map<Integer, OrderItem> cart = MenuService.getCart();

        if (cart.isEmpty()) {
            System.out.println("Cart is empty. Nothing to checkout.");
            return;
        }

        try {
            // Fetch customer details
            try (Connection conn = DBConnection.getConnection();
                 PreparedStatement stmt = conn.prepareStatement("SELECT * FROM customers WHERE id = ?")) {
                stmt.setInt(1, customerService.getCurrentCustomerId());
                ResultSet rs = stmt.executeQuery();
                if (!rs.next()) {
                    System.out.println("Customer not found.");
                    return;
                }

                String customerName = rs.getString("name");
                String phone = rs.getString("phone");
                String address = rs.getString("address");

                // Display checkout summary
                double total = 0;
                System.out.println("\n=========== CHECKOUT ============");
                System.out.println("Customer: " + customerName);
                System.out.println("Phone: " + phone);
                System.out.println("Delivery Address: " + address);
                System.out.println("\nItems in Cart:");
                System.out.println("--------------------------------------------");
                System.out.printf("%-20s %-10s %-10s %-10s\n", "Item Name", "Quantity", "Price", "Total");
                System.out.println("--------------------------------------------");
                for (OrderItem item : cart.values()) {
                    double itemTotal = item.price * item.quantity;
                    System.out.printf("%-20s %-10d %-10.2f %-10.2f\n",
                            item.name, item.quantity, item.price, itemTotal);
                    total += itemTotal;
                }
                System.out.println("--------------------------------------------");

                double discount = (total > 500) ? 50 : 0;
                double finalAmount = total - discount;

                System.out.printf("Subtotal: ₹%.2f\n", total);
                System.out.printf("Discount: ₹%.2f\n", discount);
                System.out.printf("Total: ₹%.2f\n", finalAmount);

                // Payment mode selection
                String mode;
                while (true) {
                    System.out.print("\nSelect Payment Mode (1. Cash / 2. UPI): ");
                    String input = scanner.nextLine();
                    if (input.equals("1")) {
                        mode = "Cash";
                        break;
                    } else if (input.equals("2")) {
                        mode = "UPI";
                        break;
                    } else {
                        System.out.println("Invalid choice. Enter 1 or 2.");
                    }
                }

                // Random delivery partner
                String partner;
                try (Connection conn2 = DBConnection.getConnection();
                     Statement stmt2 = conn2.createStatement();
                     ResultSet rs2 = stmt2.executeQuery("SELECT name FROM delivery_partners")) {
                    List<String> partners = new ArrayList<>();
                    while (rs2.next()) {
                        partners.add(rs2.getString("name"));
                    }
                    partner = partners.get(new Random().nextInt(partners.size()));
                }

                // Order confirmation
                while (true) {
                    System.out.print("Confirm Order? (yes/no): ");
                    String confirm = scanner.nextLine();
                    if (confirm.equalsIgnoreCase("yes")) {
                        // Save order to database
                        int orderId;
                        try (Connection conn3 = DBConnection.getConnection();
                             PreparedStatement orderStmt = conn3.prepareStatement(
                                     "INSERT INTO orders (customer_id, total, discount_applied, payment_mode, delivery_partner) VALUES (?, ?, ?, ?, ?)",
                                     Statement.RETURN_GENERATED_KEYS)) {
                            orderStmt.setInt(1, customerService.getCurrentCustomerId());
                            orderStmt.setDouble(2, total);
                            orderStmt.setDouble(3, discount);
                            orderStmt.setString(4, mode);
                            orderStmt.setString(5, partner);
                            orderStmt.executeUpdate();
                            ResultSet generatedKeys = orderStmt.getGeneratedKeys();
                            generatedKeys.next();
                            orderId = generatedKeys.getInt(1);
                        }

                        // Save order items
                        try (Connection conn4 = DBConnection.getConnection();
                             PreparedStatement itemStmt = conn4.prepareStatement(
                                     "INSERT INTO order_items (order_id, item_name, quantity, price) VALUES (?, ?, ?, ?)")) {
                            for (OrderItem item : cart.values()) {
                                itemStmt.setInt(1, orderId);
                                itemStmt.setString(2, item.name);
                                itemStmt.setInt(3, item.quantity);
                                itemStmt.setDouble(4, item.price);
                                itemStmt.executeUpdate();
                            }
                        }

                        // Display invoice
                        System.out.println("\n=========== INVOICE ============");
                        System.out.println("ORDER PLACED SUCCESSFULLY!");
                        System.out.println("Customer: " + customerName);
                        System.out.println("Phone: " + phone);
                        System.out.println("Delivery Address: " + address);
                        System.out.println("Delivery Partner: " + partner);
                        System.out.println("Payment Mode: " + mode);
                        System.out.println("\nOrder Items:");
                        System.out.println("--------------------------------------------");
                        System.out.printf("%-20s %-10s %-10s %-10s\n", "Item Name", "Quantity", "Price", "Total");
                        System.out.println("--------------------------------------------");
                        for (OrderItem item : cart.values()) {
                            double itemTotal = item.price * item.quantity;
                            System.out.printf("%-20s %-10d %-10.2f %-10.2f\n",
                                    item.name, item.quantity, item.price, itemTotal);
                        }
                        System.out.println("--------------------------------------------");
                        System.out.printf("Subtotal: ₹%.2f\n", total);
                        System.out.printf("Discount: ₹%.2f\n", discount);
                        System.out.printf("Total: ₹%.2f\n", finalAmount);
                        cart.clear();
                        break;
                    } else if (confirm.equalsIgnoreCase("no")) {
                        System.out.print("Would you like to make changes? (yes/no): ");
                        if (scanner.nextLine().equalsIgnoreCase("yes")) {
                            return; // Back to menu to modify cart
                        } else {
                            cart.clear();
                            System.out.println("Order cancelled.");
                            break;
                        }
                    } else {
                        System.out.println("Invalid input. Enter 'yes' or 'no'.");
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}