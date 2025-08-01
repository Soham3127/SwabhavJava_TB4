package com.aurionpro.bank_transaction_system;

import java.util.Scanner;

public class AdminPanel {
    public static boolean adminLogin(Scanner scanner) {
        System.out.println("\n════════════════════ Admin Login ════════════════════");
        String username = InputUtils.getNonEmptyString("Enter username: ");
        String password = InputUtils.getNonEmptyString("Enter password: ");
        if (AccountManager.validateAdminCredentials(username, password)) {
            System.out.println("Admin login successful.");
            System.out.println("═════════════════════════════════════════════════════");
            return true;
        } else {
            System.out.println("Invalid admin credentials.");
            System.out.println("═════════════════════════════════════════════════════");
            return false;
        }
    }

    public static void showAdminPanel(Scanner scanner) {
        if (!adminLogin(scanner)) {
            return;
        }
        while (true) {
            System.out.println("\n════════════════════ Admin Panel ════════════════════");
            System.out.println("1. View All Accounts");
            System.out.println("2. Create New Account");
            System.out.println("3. Delete Account (Freeze)");
            System.out.println("4. Update Account Details");
            System.out.println("5. View Transactions");
            System.out.println("6. Unfreeze Account");
            System.out.println("7. Exit Admin Panel");
            int choice = InputUtils.getValidatedInt("Enter your choice: ");
            System.out.println("═════════════════════════════════════════════════════");
            switch (choice) {
                case 1 -> AccountManager.viewAllAccounts();
                case 2 -> AccountManager.createAccount();
                case 3 -> {
                    AccountManager.viewAllAccounts();
                    int id = InputUtils.getValidatedInt("Enter Account ID to delete (freeze): ");
                    if (AccountManager.doesAccountExist(id)) {
                        AccountManager.deleteAccount(id);
                    } else {
                        System.out.println("Account ID not found.");
                        System.out.println("═════════════════════════════════════════════════════");
                    }
                }
                case 4 -> {
                    AccountManager.displayActiveAccounts();
                    int id = InputUtils.getValidatedInt("Enter Account ID to update: ");
                    if (AccountManager.doesAccountExist(id)) {
                        AccountManager.updateAccountDetails(id);
                    } else {
                        System.out.println("Account ID not found.");
                        System.out.println("═════════════════════════════════════════════════════");
                    }
                }
                case 5 -> {
                    System.out.println("\n════════════════════ View Transactions ════════════════════");
                    System.out.println("1. View All Transactions");
                    System.out.println("2. View Transactions for Specific Account");
                    int transChoice = InputUtils.getValidatedInt("Enter your choice: ");
                    System.out.println("═══════════════════════════════════════════════════════════");
                    if (transChoice == 1) {
                        TransactionManager.viewAllTransactions();
                    } else if (transChoice == 2) {
                        AccountManager.viewAllAccounts();
                        int id = InputUtils.getValidatedInt("Enter Account ID to view transactions: ");
                        if (AccountManager.doesAccountExist(id)) {
                            TransactionManager.viewTransactionsByAccount(id);
                        } else {
                            System.out.println("Account ID not found.");
                            System.out.println("═════════════════════════════════════════════════════");
                        }
                    } else {
                        System.out.println("Invalid choice. Try again.");
                        System.out.println("═════════════════════════════════════════════════════");
                    }
                }
                case 6 -> {
                    AccountManager.displayInactiveAccounts();
                    int id = InputUtils.getValidatedInt("Enter Account ID to unfreeze: ");
                    if (AccountManager.doesAccountExist(id)) {
                        AccountManager.unfreezeAccount(id);
                    } else {
                        System.out.println("Account ID not found.");
                        System.out.println("═════════════════════════════════════════════════════");
                    }
                }
                case 7 -> {
                    System.out.println("Exiting Admin Panel.");
                    System.out.println("═════════════════════════════════════════════════════");
                    return;
                }
                default -> {
                    System.out.println("Invalid choice. Try again.");
                    System.out.println("═════════════════════════════════════════════════════");
                }
            }
        }
    }
}