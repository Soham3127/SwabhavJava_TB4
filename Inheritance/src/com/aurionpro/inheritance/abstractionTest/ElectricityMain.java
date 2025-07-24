package com.aurionpro.inheritance.abstractionTest;

import com.aurionpro.inheritance.abstraction.CommercialCustomer;
import com.aurionpro.inheritance.abstraction.Customer;
import com.aurionpro.inheritance.abstraction.ResidentialCustomer;
import java.util.Scanner;

public class ElectricityMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("-------Electricity Billing System-----");
			System.out.println("1. Calculate Bills");
			System.out.println("2. Exit");
			System.out.print("Choose option: ");
			String option = scanner.nextLine();

			if (option.equals("1")) {
				Customer[] customer = new Customer[3];

				for (int i = 0; i < 3; i++) {
					System.out.println("\nEnter Customer " + (i + 1) + " details:");
					System.out.print("Name: ");
					String name = scanner.nextLine();

					System.out.print("Units Consumed: ");
					int units = Integer.valueOf(scanner.nextLine()); // Safer to use nextLine()

					System.out.print("Type (1-Residential, 2-Commercial): ");
					String type = scanner.nextLine();

					if (type.equals("1")) {
						customer[i] = new ResidentialCustomer(name, units);
					} else {
						customer[i] = new CommercialCustomer(name, units);
					}
				}

				System.out.println("\n--- Bills ---");
				for (Customer c : customer) {
					System.out.println(c.name + " Bill: ₹" + c.calculateBill());
				}
				System.out.println("----------------------------------------\n");
			}

			else if (option.equals("2")) {
				System.out.println("Exiting...");
				break;
			} else {
				System.out.println("Invalid input! Please choose 1 or 2.\n");

			}
		}
		scanner.close();

	}
}
