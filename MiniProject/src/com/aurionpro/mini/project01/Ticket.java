package com.aurionpro.mini.project01;

public class Ticket {
	String customerName;
	TicketType type;
	BookingStatus status;
	int price;

	public Ticket(String customerName, TicketType type) {
		this.customerName = customerName;
		this.type = type;
		// this.status= BookingStatus.PENDING;
		this.price = type.getPrice();

	}

	public void displayTicket() {
		System.out.println("-----Ticket Details------");
		System.out.println("Customer Name: " + customerName);
		System.out.println("Ticket Type: " + type);
		System.out.println("Ticket Price: " + price);
		System.out.println("Booking Status: " + status);

		System.out.println("----------------------------");
	}

}
