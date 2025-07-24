package com.aurionpro.interface01;

import java.util.Scanner;

public class PaymentMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IPayment payment = null;
        boolean continuePayments = true;

        System.out.println("----- Welcome to Payment System -----");

        while (continuePayments) {
            String choice = "";
            double amount = 0;

            // Input for payment method
            while (true) {
                System.out.println("\nSelect Payment Method:");
                System.out.println("1. Credit Card");
                System.out.println("2. Debit Card");
                System.out.println("3. UPI Payment");
                System.out.println("4. Exit");

                System.out.print("Enter your choice (1/2/3/4): ");
                choice = scanner.nextLine().trim();

                if (choice.equals("1") || choice.equals("2") || choice.equals("3") || choice.equals("4")) {
                    break;
                } else {
                    System.out.println("Invalid choice! Please enter 1, 2, 3, or 4.");
                }
            }

            if (choice.equals("4")) {
                System.out.println("Exiting...");
                break;
            }

            // Input for amount
            while (true) {
                System.out.print("Enter the amount to pay: ");
                String input = scanner.nextLine().trim();

                if (input.matches("\\d+(\\.\\d+)?")) {
                    try {
                        amount = convertToDouble(input);
                        if (amount <= 0) {
                            throw new InvalidAmountException("Amount must be greater than 0.");
                        }
                        break;
                    } catch (InvalidAmountException e) {
                        System.out.println(e.getMessage());
                    }
                } else {
                    System.out.println("Invalid input! Please enter a valid numeric amount.");
                }
            }

            // Select payment type
            if (choice.equals("1")) {
                payment = new CreditCardPayment();
            } else if (choice.equals("2")) {
                payment = new DebitCardPayment();
            } else {
                payment = new UpiPayment();
            }

            // Process payment
            System.out.println("\n----- Payment Processing -----");
            payment.processPayment(amount);
            System.out.println("----- Payment Successful! -----");

            // Ask to continue
            while (true) {
                System.out.print("Do you want to make another payment? (yes/no): ");
                String again = scanner.nextLine().trim().toLowerCase();
                if (again.equals("yes")) {
                    break;
                } else if (again.equals("no")) {
                    continuePayments = false;
                    System.out.println("Exiting... Thank you for using the Payment System!");
                    break;
                } else {
                    System.out.println("Invalid input. Please enter yes or no.");
                }
            }
        }

        scanner.close();
    }

    // Manual conversion (no parsing)
    private static double convertToDouble(String input) {
        double value = 0;
        double decimal = 0;
        boolean hasDecimal = false;
        int decimalCount = 0;

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '.') {
                hasDecimal = true;
                continue;
            }

            if (!hasDecimal) {
                value = value * 10 + (ch - '0');
            } else {
                decimal = decimal * 10 + (ch - '0');
                decimalCount++;
            }
        }

        for (int i = 0; i < decimalCount; i++) {
            decimal /= 10;
        }

        return value + decimal;
    }
}
