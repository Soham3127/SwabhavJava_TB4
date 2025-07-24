package coom.aurionpro.ennumeration;

import java.util.Scanner;

public class PaymentTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("---- Payment Status Tracker ----");
        System.out.println("Choose Payment Status:");
        System.out.println("1. SUCCESS");
        System.out.println("2. PENDING");
        System.out.println("3. FAILED");
        System.out.println("4. CANCELLED");
        System.out.print("Enter choice (1-4): ");

        int choice = scanner.nextInt();
        PaymentStatus status = PaymentStatus.PENDING;  // Default

        switch (choice) {
            case 1:
                status = PaymentStatus.SUCCESS;
                break;
            case 2:
                status = PaymentStatus.PENDING;
                break;
            case 3:
                status = PaymentStatus.FAILED;
                break;
            case 4:
                status = PaymentStatus.CANCELLED;
                break;
            default:
                System.out.println("Invalid choice. Defaulting to PENDING.");
        }

        System.out.println("Status: " + status);
        System.out.println("Message: " + status.getStatus());
        scanner.close();
    }
}
