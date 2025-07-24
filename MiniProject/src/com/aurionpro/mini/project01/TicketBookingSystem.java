package com.aurionpro.mini.project01;

import java.util.Scanner;

public class TicketBookingSystem {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("---Ticket Booking System--- ");
		System.out.print("Enter your name: ");
		String name = scanner.nextLine();

		// Ticket Type Selection
		System.out.println("Select your Ticket Type:");
		System.out.println("1. Regular(100)");
		System.out.println("2. VIP(200)");
		System.out.println("3. Premium(300)");
		System.out.print("Select a option between(1-3): ");
		int option = scanner.nextInt();

		TicketType type = TicketType.REGULAR;

		switch (option) {

		case 1:
			type = TicketType.REGULAR;
			break;

		case 2:
			type = TicketType.VIP;
			break;

		case 3:
			type = TicketType.PREMIUM;
			break;

		default:
			System.out.println("Invalid Choice, Choose the correct option");
			break;

		}
		// Create ticket object
		Ticket ticket = new Ticket(name, type);

		ticket.displayTicket();

		// Status Selection

		System.out.println("Confirm your Booking Status: ");
		System.out.println("1. Confirm Booking");
		System.out.println("2. Cancel Booking");
		System.out.print("Enter your choice (1-2): ");

		int statusChoice = scanner.nextInt();
		
		 
		switch (statusChoice) {
		case 1:
			ticket.status = BookingStatus.CONFIRM;
			break;

		case 2:
			ticket.status = BookingStatus.CANCELLED;
			break;
		default:
			System.out.println("Invalid Choice,(Current status PENDING)");
			ticket.status = BookingStatus.PENDING;

			

		}

		ticket.displayTicket();

		System.out.println("Thank You!!");
		scanner.close();
	}

}
