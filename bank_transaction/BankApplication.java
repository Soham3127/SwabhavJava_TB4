package com.aurionpro.jdbc.bank_transaction;

import java.util.Scanner;

public class BankApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AccountService accService = new AccountService(sc);
        TransactionService txService = new TransactionService(sc);

        while (true) {
            System.out.println("\n-------BANK MENU-------");
            System.out.println("1. Add New Account");
            System.out.println("2. Transfer Money");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. View Transaction History");
            System.out.println("6. View All Accounts");
            System.out.println("7. Delete Account");
            System.out.println("8. View Account Balance");
            System.out.println("9. Exit");

            System.out.print("Enter your choice: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1" -> accService.addAccount();
                case "2" -> txService.transferMoney();
                case "3" -> txService.depositMoney();
                case "4" -> txService.withdrawMoney();
                case "5" -> txService.viewTransactionHistory();
                case "6" -> accService.viewAllAccounts();
                case "7" -> accService.deleteAccount();
                case "8" -> accService.viewBalance();
                case "9" -> {
                    System.out.println("Thank you for using our Bank System.");
                    return;
                }
                default -> System.out.println(" Invalid choice. Try again.");
            }
        }
    }
}
