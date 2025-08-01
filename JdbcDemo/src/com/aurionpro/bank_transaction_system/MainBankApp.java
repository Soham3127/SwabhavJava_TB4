package com.aurionpro.bank_transaction_system;

import java.util.Scanner;

public class MainBankApp {
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("\n════════════════════ Welcome to Bank System ════════════════════");
            System.out.println("1. Admin Panel");
            System.out.println("2. Customer Panel");
            System.out.println("3. Exit");
            int choice = InputUtils.getValidatedIntInRange("Enter your choice", 1, 3);
            System.out.println("═════════════════════════════════════════════════════════════════════");
            switch (choice) {
                case 1 -> AdminPanel.showAdminPanel(scanner);
                case 2 -> customerPanel();
                case 3 -> {
                    System.out.println("Thank you for using the Bank. Goodbye!");
                    System.out.println("═════════════════════════════════════════════════════════════════════");
                    scanner.close();
                    return;
                }
                default -> {
                    System.out.println("Invalid choice. Please try again.");
                    System.out.println("═════════════════════════════════════════════════════════════════════");
                }
            }
        }
    }

    private void customerPanel() {
        while (true) {
            System.out.println("\n════════════════════ Customer Section ════════════════════");
            System.out.println("1. New Customer");
            System.out.println("2. Existing Customer");
            System.out.println("3. Back to Main Menu");
            int choice = InputUtils.getValidatedIntInRange("Enter your choice", 1, 3);
            System.out.println("══════════════════════════════════════════════════════════");
            switch (choice) {
                case 1 -> newCustomerRegistration();
                case 2 -> CustomerPanel.start(scanner);
                case 3 -> {
                    System.out.println("Returning to Main Menu.");
                    System.out.println("═══════════════════════════════════════════════════════");
                    return;
                }
                default -> {
                    System.out.println("Invalid choice. Please try again.");
                    System.out.println("═══════════════════════════════════════════════════════");
                }
            }
        }
    }

    private void newCustomerRegistration() {
        System.out.println("\n════════════════════ New Customer Registration ════════════════════");
        int accountId;
        while (true) {
            accountId = InputUtils.getValidatedIntInRange("Enter desired Account ID", 101, 999);
            if (!AccountManager.doesAccountExist(accountId)) break;
            System.out.println("Account ID already exists. Try a different one.");
        }
        String name = InputUtils.getNonEmptyString("Enter Name: ");
        int age = InputUtils.getValidatedIntInRange("Enter Age", 18, 60);
        String gender = InputUtils.getValidatedGender("Enter Gender");
        String phone = InputUtils.getValidatedPhone("Enter Phone Number: ");
        int initialBalance = InputUtils.getValidatedAmount("Enter Initial Balance (Minimum 500, multiple of 100): ", 100, 500);
        int pin = InputUtils.readMaskedPIN("Enter 4-digit PIN: ");

        AccountManager.createAccount(accountId, name, age, gender, phone, pin, initialBalance);
        System.out.println("Registration complete. Returning to Customer Panel.");
        System.out.println("═══════════════════════════════════════════════════════════════");
    }

    public static void main(String[] args) {
        new MainBankApp().start();
    }
}