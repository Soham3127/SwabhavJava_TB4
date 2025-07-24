package com.aurionpro.mini.project04.OnlineShoppingPlatform;

import java.util.Scanner;

public class OnlineShoppingPlatformMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			double amount = 0;
			int quantity = 0;
			
			System.out.println("----Online Shopping Platform ----");
			
			System.out.print("Enter the customer name: ");
			String customerName = scanner.nextLine();

			System.out.print("Enter the Product Type (Like Electronics, Books, Clothing): ");
			String productType = scanner.nextLine();

			// Price and Quantity input
			while (true) {
				try {
					System.out.print("Enter price per unit: ");
					amount = scanner.nextDouble();

					System.out.print("Enter quantity: ");
					quantity = scanner.nextInt();

					scanner.nextLine();
					break;
				} catch (Exception e) {
					System.out.println("Enter a valid number!!");
					scanner.nextLine();
				}
			}

			Order order = new Order(customerName, productType, amount, quantity);

			// Discount Calculation
			IDiscountStratergy discountStratergy;
			System.out.print("Do you have a membership (yes/no): ");
			String membership = scanner.nextLine().toLowerCase();

			if (membership.equals("yes")) {
				discountStratergy = new LoyaltyDiscount();
			} else if (productType.equalsIgnoreCase("ELECTRONICS")) {
				discountStratergy = new ElectronicsDiscount();
			} else {
				discountStratergy = new NoDiscount();
			}

			// Payment Method
			PaymentProcessor paymentProcessor;
			while (true) {
				try {
					System.out.println("Select Payment Method:");
					System.out.println("1. Credit Card");
					System.out.println("2. PayPal");
					System.out.print("Enter your choice (1/2): ");
					int choice = scanner.nextInt();
					scanner.nextLine();

					switch (choice) {
					case 1:
						paymentProcessor = new CreditCardProcessor();
						break;
					case 2:
						paymentProcessor = new PayPalProcessor();
						break;
					default:
						System.out.println("Invalid choice, enter between 1 and 2");
						continue;
					}
					break;
				} catch (Exception e) {
					System.out.println("Enter a number!!");
					scanner.nextLine();
				}
			}

			//Notification Method 
			INotifier notifier = null;
			while (notifier == null) {
				try {
					System.out.println("Select Notification Method:");
					System.out.println("1. Email");
					System.out.println("2. SMS");
					System.out.print("Enter your choice (1/2): ");
					int choice = scanner.nextInt();
					scanner.nextLine();

					switch (choice) {
						case 1:
							notifier = new EmailNotifier();
							break;
						case 2:
							notifier = new SMS();
							break;
						default:
							System.out.println("Invalid choice, enter between 1 and 2");
					}
				} catch (Exception e) {
					System.out.println("Enter a number!!");
					scanner.nextLine();
				}
			}
			System.out.println("--------------------------------------");
			// Process Order
			OrderProcessor processor = new OrderProcessor(discountStratergy, paymentProcessor, notifier);
			processor.process(order);

			System.out.println("Order successfully placed!");

			// Ask if user wants to place another order
			System.out.print("Do you want to place another order? (yes/no): ");
			String again = scanner.nextLine().toLowerCase();
			if (!again.equals("yes")) {
				System.out.println("Thank you for shopping !");
				break;
			}
			
			

			System.out.println("--- Starting new order ---");
		}
		scanner.close();
	}
	
	
}
