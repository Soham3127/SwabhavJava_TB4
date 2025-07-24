package com.aurionpro.errorhandling;

import java.util.Scanner;

public class AtmCashWithdrawal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int bal = 10000;

        System.out.print("Amount to withdraw: ");
        int amount = scanner.nextInt();

        try {
            if (amount > bal) {
                throw new ArithmeticException("Not Allowed");
            } else {
                System.out.println("Balance: " + (bal - amount));
            }
        } 
        catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } 
        finally {
            System.out.println("Transaction Ended");
        }

        scanner.close();
    }
}

