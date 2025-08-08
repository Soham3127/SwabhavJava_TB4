package com.foodorderingsystem;

import java.sql.*;
import java.util.*;

public class MenuService {
    static Map<Integer, OrderItem> cart = new LinkedHashMap<>();

    public static void handleMenuSelection(Scanner scanner, CustomerService customerService) {
        while (true) {
            try {
                System.out.println("\n====== CUSTOMER MENU ======");
                System.out.println("1. Veg");
                System.out.println("2. NonVeg");
                System.out.println("3. Dessert");
                System.out.println("4. View Cart and Checkout");
                System.out.println("5. View Order History");
                System.out.println("6. Back to Main Menu");
                System.out.print("Enter choice: ");
                String choice = scanner.nextLine();

                switch (choice) {
                    case "1":
                        showMenuItemsByCategory("Veg", scanner);
                        break;
                    case "2":
                        showMenuItemsByCategory("NonVeg", scanner);
                        break;
                    case "3":
                        showMenuItemsByCategory("Dessert", scanner);
                        break;
                    case "4":
                        CheckoutService.proceedToCheckout(scanner, customerService);
                        break;
                    case "5":
                        customerService.viewOrderHistory();
                        break;
                    case "6":
                        cart.clear();
                        return;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } catch (SQLException e) {
                System.out.println("Database error: " + e.getMessage());
            }
        }
    }

    private static void showMenuItemsByCategory(String category, Scanner scanner) throws SQLException {
        while (true) {
            try (Connection conn = DBConnection.getConnection();
                 PreparedStatement stmt = conn.prepareStatement("SELECT * FROM menu_items WHERE category = ?")) {
                stmt.setString(1, category);
                ResultSet rs = stmt.executeQuery();

                Map<Integer, String> idToName = new HashMap<>();
                System.out.println("\n------------------ " + category.toUpperCase() + " MENU ------------------");
                System.out.printf("%-5s %-20s %-10s\n", "ID", "Name", "Price");
                System.out.println("-------------------------------------");
                while (rs.next()) {
                    int id = rs.getInt("id");
                    idToName.put(id, rs.getString("name"));
                    System.out.printf("%-5d %-20s %-10.2f\n", id, rs.getString("name"), rs.getDouble("price"));
                }

                int id;
                while (true) {
                    System.out.print("Enter Item ID to add to cart (0 to go back): ");
                    try {
                        id = Integer.parseInt(scanner.nextLine());
                        if (id == 0) return;
                        if (idToName.containsKey(id)) break;
                        System.out.println("Invalid ID.");
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid number.");
                    }
                }

                int qty;
                while (true) {
                    System.out.print("Enter quantity: ");
                    try {
                        qty = Integer.parseInt(scanner.nextLine());
                        if (qty > 0) break;
                        System.out.println("Quantity must be positive.");
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid number.");
                    }
                }

                try (PreparedStatement itemStmt = conn.prepareStatement("SELECT * FROM menu_items WHERE id = ?")) {
                    itemStmt.setInt(1, id);
                    ResultSet itemRs = itemStmt.executeQuery();
                    if (itemRs.next()) {
                        OrderItem item = new OrderItem(id, itemRs.getString("name"), qty, itemRs.getDouble("price"));
                        cart.put(id, item);
                        System.out.println("Added to cart.");
                    }
                }

                // Prompt to order more from the same category
                while (true) {
                    System.out.print("Do you want to order more from the " + category + " menu? (yes/no): ");
                    String orderMore = scanner.nextLine();
                    if (orderMore.equalsIgnoreCase("yes")) {
                        break; // Loop back to display the same category menu
                    } else if (orderMore.equalsIgnoreCase("no")) {
                        return; // Return to customer menu
                    } else {
                        System.out.println("Invalid input. Enter 'yes' or 'no'.");
                    }
                }
            }
        }
    }

    public static Map<Integer, OrderItem> getCart() {
        return cart;
    }
}