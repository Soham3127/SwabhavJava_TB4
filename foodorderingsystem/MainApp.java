package com.foodorderingsystem;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomerService customerService = new CustomerService();

        while (true) {
            System.out.println("\n====== WELCOME TO MINI FOOD ORDERING SYSTEM ======");
            System.out.println("Please choose your role:");
            System.out.println("1. Admin");
            System.out.println("2. New Customer Registration");
            System.out.println("3. Existing Customer Login");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            String choice = scanner.nextLine();

            try {
                switch (choice) {
                    case "1":
                        AdminService.handleAdminActions(scanner);
                        break;
                    case "2":
                        customerService.register(scanner);
                        break;
                    case "3":
                        if (customerService.login(scanner)) {
                            MenuService.handleMenuSelection(scanner, customerService);
                        }
                        break;
                    case "4":
                        System.out.println("Thank you for using Mini Food Ordering System! ");
                        scanner.close();
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}