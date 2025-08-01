package com.aurionpro.bank_transaction_system;

import java.util.Scanner;

public class CustomerPanel {
    public static void start(Scanner scanner) {
        System.out.println("\n════════════════════ Existing Customer Login ════════════════════");
        int id = InputUtils.getValidatedInt("Enter Account ID: ");
        if (!AccountManager.doesAccountExist(id)) {
            System.out.println("Account not found.");
            System.out.println("═══════════════════════════════════════════════════════════════");
            return;
        }
        if (!AccountManager.isAccountActive(id)) {
            System.out.println("Account is frozen. Contact admin to reactivate.");
            System.out.println("═══════════════════════════════════════════════════════════════");
            return;
        }

        int attempts = 0;
        while (attempts < 5) {
            int pin = InputUtils.readMaskedPIN("Enter PIN: ");
            if (AccountManager.validatePin(id, pin)) {
                Customer customer = AccountManager.getCustomer(id);
                System.out.println("Login successful. Welcome, " + customer.getName());
                AccountManager.resetWrongAttempts(id);
                customerMenu(scanner, id);
                System.out.println("═══════════════════════════════════════════════════════════════");
                return;
            } else {
                attempts++;
                AccountManager.incrementWrongAttempts(id);
                System.out.println("Incorrect PIN. " + (5 - attempts) + " attempts remaining.");
                System.out.println("═══════════════════════════════════════════════════════════════");
            }
        }
        System.out.println("Account frozen due to multiple failed attempts.");
        System.out.println("═══════════════════════════════════════════════════════════════");
    }

    private static void customerMenu(Scanner scanner, int id) {
        while (true) {
            System.out.println("\n════════════════════ Customer Menu for " + AccountManager.getCustomer(id).getName() + " ════════════════════");
            System.out.println("1. Transfer Money");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. View Balance");
            System.out.println("5. View Transaction History");
            System.out.println("6. Change PIN");
            System.out.println("7. Logout");
            int choice = InputUtils.getValidatedIntInRange("Choose an option", 1, 7);
            System.out.println("═══════════════════════════════════════════════════════════════");
            switch (choice) {
                case 1 -> transferMoney(scanner, id);
                case 2 -> deposit(scanner, id);
                case 3 -> withdraw(scanner, id);
                case 4 -> AccountManager.showBalance(id);
                case 5 -> TransactionManager.viewTransactionsByAccount(id);
                case 6 -> AccountManager.changePin(id);
                case 7 -> {
                    System.out.println("Logged out.");
                    System.out.println("═══════════════════════════════════════════════════════════════");
                    return;
                }
                default -> {
                    System.out.println("Invalid choice. Please try again.");
                    System.out.println("═══════════════════════════════════════════════════════════════");
                }
            }
        }
    }

    private static void transferMoney(Scanner scanner, int senderId) {
        System.out.println("\n════════════════════ Transfer Money ════════════════════");
        Customer sender = AccountManager.getCustomer(senderId);
        int pin = InputUtils.readMaskedPIN("Enter PIN to verify: ");
        if (!AccountManager.validatePin(senderId, pin)) {
            System.out.println("Incorrect PIN.");
            AccountManager.incrementWrongAttempts(senderId);
            System.out.println("═════════════════════════════════════════════════════");
            return;
        }
        while (true) {
            int receiverId = InputUtils.getValidatedInt("Enter Receiver Account ID: ");
            if (senderId == receiverId) {
                System.out.println("Cannot transfer to the same account. Please enter a different Receiver Account ID.");
                continue;
            }
            int amount = InputUtils.getValidatedPositiveInt("Enter amount to transfer (must be positive): ");
            TransactionManager.transfer(senderId, receiverId, amount);
            System.out.println("═════════════════════════════════════════════════════");
            break;
        }
    }

    private static void deposit(Scanner scanner, int id) {
        System.out.println("\n════════════════════ Deposit Money ════════════════════");
        int amount = InputUtils.getValidatedAmount("Enter deposit amount (multiple of 100, min 100): ", 100, 100);
        TransactionManager.deposit(id, amount);
        System.out.println("═══════════════════════════════════════════════════════");
    }

    private static void withdraw(Scanner scanner, int id) {
        System.out.println("\n════════════════════ Withdraw Money ════════════════════");
        int pin = InputUtils.readMaskedPIN("Enter PIN to verify: ");
        if (!AccountManager.validatePin(id, pin)) {
            System.out.println("Incorrect PIN.");
            AccountManager.incrementWrongAttempts(id);
            System.out.println("═══════════════════════════════════════════════════════");
            return;
        }
        int amount = InputUtils.getValidatedAmount("Enter withdrawal amount (multiple of 100, min 100): ", 100, 100);
        TransactionManager.withdraw(id, amount);
        System.out.println("═══════════════════════════════════════════════════════");
    }
}