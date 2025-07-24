package com.aurionpro.mini.project01;

public enum TicketType {
	REGULAR(100),
	VIP(200), 
	PREMIUM(300);

	private int price;

	TicketType(int price) {
		this.price=price;

	}

	public int getPrice() {
		return price;
	}

}
