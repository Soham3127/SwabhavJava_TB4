package com.foodorderingsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminService {
    public static void handleAdminActions(Scanner scanner) {
        while (true) {
            System.out.print("Enter admin username: ");
            String username = scanner.nextLine();
            System.out.print("Enter admin password: ");
            String password = scanner.nextLine();

            try (Connection conn = DBConnection.getConnection()) {
                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM admin WHERE username = ? AND password = ?");
                stmt.setString(1, username);
                stmt.setString(2, password);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    System.out.println("Admin login successful!");
                    adminMenu(scanner);
                    return;
                } else {
                    System.out.println("Invalid admin credentials. Try again.");
                }
            } catch (SQLException e) {
                System.out.println("Database error: " + e.getMessage());
            }
        }
    }

    private static void adminMenu(Scanner scanner) {
        while (true) {
            System.out.println("\n====== ADMIN PANEL ======");
            System.out.println("1. View Menu Items");
            System.out.println("2. Add New Menu Item");
            System.out.println("3. Update Menu Item");
            System.out.println("4. Delete Menu Item");
            System.out.println("5. Manage Delivery Partners");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            try {
                switch (choice) {
                    case "1":
                        viewMenu();
                        break;
                    case "2":
                        addFoodItem(scanner);
                        break;
                    case "3":
                        updateMenuItem(scanner);
                        break;
                    case "4":
                        deleteMenuItem(scanner);
                        break;
                    case "5":
                        manageDeliveryPartners(scanner);
                        break;
                    case "6":
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (SQLException e) {
                System.out.println("Database error: " + e.getMessage());
            }
        }
    }

    private static void addFoodItem(Scanner scanner) throws SQLException {
        System.out.print("Enter food name: ");
        String name = scanner.nextLine();
        String category;
        while (true) {
            System.out.print("Enter category (Veg/NonVeg/Dessert): ");
            category = scanner.nextLine();
            if (category.equalsIgnoreCase("Veg") || category.equalsIgnoreCase("NonVeg") || category.equalsIgnoreCase("Dessert")) {
                break;
            }
            System.out.println("Invalid category. Must be Veg, NonVeg, or Dessert.");
        }
        double price;
        while (true) {
            System.out.print("Enter price: ");
            try {
                price = Double.parseDouble(scanner.nextLine());
                if (price >= 0) break;
                System.out.println("Price cannot be negative.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid price. Please enter a number.");
            }
        }

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO menu_items (name, category, price) VALUES (?, ?, ?)")) {
            stmt.setString(1, name);
            stmt.setString(2, category);
            stmt.setDouble(3, price);
            stmt.executeUpdate();
            System.out.println("Food item added successfully.");
        }
    }

    private static void viewMenu() throws SQLException {
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM menu_items")) {
            System.out.println("\n------------------ MENU ITEMS ------------------");
            System.out.printf("%-5s %-20s %-10s %-10s\n", "ID", "Name", "Category", "Price");
            System.out.println("-----------------------------------------------");
            while (rs.next()) {
                System.out.printf("%-5d %-20s %-10s %-10.2f\n",
                        rs.getInt("id"), rs.getString("name"), rs.getString("category"), rs.getDouble("price"));
            }
        }
    }

    private static void updateMenuItem(Scanner scanner) throws SQLException {
        viewMenu();
        int id;
        while (true) {
            System.out.print("Enter Item ID to update (0 to go back): ");
            try {
                id = Integer.parseInt(scanner.nextLine());
                if (id == 0) return;
                if (isValidItemId(id)) break;
                System.out.println("Invalid ID.");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }

        System.out.print("Enter new food name (leave blank to keep unchanged): ");
        String name = scanner.nextLine();
        String category;
        while (true) {
            System.out.print("Enter new category (Veg/NonVeg/Dessert, leave blank to keep unchanged): ");
            category = scanner.nextLine();
            if (category.isEmpty() || category.equalsIgnoreCase("Veg") || category.equalsIgnoreCase("NonVeg") || category.equalsIgnoreCase("Dessert")) {
                break;
            }
            System.out.println("Invalid category. Must be Veg, NonVeg, or Dessert.");
        }
        double price;
        while (true) {
            System.out.print("Enter new price (leave blank to keep unchanged): ");
            String priceInput = scanner.nextLine();
            if (priceInput.isEmpty()) {
                price = -1; 
                break;
            }
            try {
                price = Double.parseDouble(priceInput);
                if (price >= 0) break;
                System.out.println("Price cannot be negative.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid price. Please enter a number or leave blank.");
            }
        }

        try (Connection conn = DBConnection.getConnection()) {
            StringBuilder sql = new StringBuilder("UPDATE menu_items SET ");
            List<Object> params = new ArrayList<>();
            int paramIndex = 1;

            if (!name.isEmpty()) {
                sql.append("name = ?, ");
                params.add(name);
            }
            if (!category.isEmpty()) {
                sql.append("category = ?, ");
                params.add(category);
            }
            if (price >= 0) {
                sql.append("price = ?, ");
                params.add(price);
            }
            sql.setLength(sql.length() - 2); // Remove trailing comma
            sql.append(" WHERE id = ?");
            params.add(id);

            PreparedStatement stmt = conn.prepareStatement(sql.toString());
            for (int i = 0; i < params.size(); i++) {
                stmt.setObject(i + 1, params.get(i));
            }
            int rows = stmt.executeUpdate();
            System.out.println(rows > 0 ? "Menu item updated successfully." : "Update failed.");
        }
    }

    private static void deleteMenuItem(Scanner scanner) throws SQLException {
        viewMenu();
        int id;
        while (true) {
            System.out.print("Enter Item ID to delete (0 to go back): ");
            try {
                id = Integer.parseInt(scanner.nextLine());
                if (id == 0) return;
                if (isValidItemId(id)) break;
                System.out.println("Invalid ID.");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM menu_items WHERE id = ?")) {
            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            System.out.println(rows > 0 ? "Menu item deleted successfully." : "Deletion failed.");
        }
    }

    private static void manageDeliveryPartners(Scanner scanner) throws SQLException {
        while (true) {
            System.out.println("\n====== MANAGE DELIVERY PARTNERS ======");
            System.out.println("1. View Delivery Partners");
            System.out.println("2. Add Delivery Partner");
            System.out.println("3. Delete Delivery Partner");
            System.out.println("4. Back to Admin Menu");
            System.out.print("Enter choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    viewDeliveryPartners();
                    break;
                case "2":
                    addDeliveryPartner(scanner);
                    break;
                case "3":
                    deleteDeliveryPartner(scanner);
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void viewDeliveryPartners() throws SQLException {
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM delivery_partners")) {
            System.out.println("\n------------------ DELIVERY PARTNERS ------------------");
            System.out.printf("%-5s %-20s\n", "ID", "Name");
            System.out.println("------------------------------------");
            while (rs.next()) {
                System.out.printf("%-5d %-20s\n", rs.getInt("id"), rs.getString("name"));
            }
        }
    }

    private static void addDeliveryPartner(Scanner scanner) throws SQLException {
        System.out.print("Enter delivery partner name: ");
        String name = scanner.nextLine();
        if (name.trim().isEmpty()) {
            System.out.println("Name cannot be empty.");
            return;
        }

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO delivery_partners (name) VALUES (?)")) {
            stmt.setString(1, name);
            stmt.executeUpdate();
            System.out.println("Delivery partner added successfully.");
        }
    }

    private static void deleteDeliveryPartner(Scanner scanner) throws SQLException {
        viewDeliveryPartners();
        int id;
        while (true) {
            System.out.print("Enter Delivery Partner ID to delete (0 to go back): ");
            try {
                id = Integer.parseInt(scanner.nextLine());
                if (id == 0) return;
                try (Connection conn = DBConnection.getConnection();
                     PreparedStatement stmt = conn.prepareStatement("SELECT * FROM delivery_partners WHERE id = ?")) {
                    stmt.setInt(1, id);
                    if (stmt.executeQuery().next()) break;
                    System.out.println("Invalid ID.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM delivery_partners WHERE id = ?")) {
            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            System.out.println(rows > 0 ? "Delivery partner deleted successfully." : "Deletion failed.");
        }
    }

    private static boolean isValidItemId(int id) throws SQLException {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM menu_items WHERE id = ?")) {
            stmt.setInt(1, id);
            return stmt.executeQuery().next();
        }
    }
}