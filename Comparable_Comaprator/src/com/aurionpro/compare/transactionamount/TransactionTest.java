package com.aurionpro.compare.transactionamount;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;



public class TransactionTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Transaction> transactions = new ArrayList<>();

        int n = 0;
        while (true) {
            try {
                System.out.print("Enter number of transactions: ");
                n = sc.nextInt();
                sc.nextLine(); 
                if (n <= 0) {
                    System.out.println("Number must be greater than 0.");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("❌ Please enter a valid integer.");
                sc.nextLine(); 
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.println("\nTransaction " + i + ":");

          
            int id = 0;
            while (true) {
                try {
                    System.out.print("ID: ");
                    id = sc.nextInt();
                    if (id <= 0) {
                        System.out.println("❌ ID must be a positive number.");
                    } else {
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("❌ Enter a valid integer for ID.");
                } finally {
                    sc.nextLine();
                }
            }

           
            double amount = 0;
            while (true) {
                try {
                    System.out.print("Amount: ");
                    amount = sc.nextDouble();
                    if (amount < 0) {
                        System.out.println("❌ Amount cannot be negative.");
                    } else {
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("❌ Enter a valid number for amount.");
                } finally {
                    sc.nextLine(); 
                }
            }

            transactions.add(new Transaction(id, amount));
        }

        System.out.println("\nTransactions Before Sorting:");
        for (Transaction t : transactions) {
            System.out.println(t);
        }

        Collections.sort(transactions, new TransactionComparator());

        System.out.println("\nTransactions After Sorting (by Amount Desc, then ID Asc):");
        for (Transaction t : transactions) {
            System.out.println(t);
        }

        sc.close();
    }
}
