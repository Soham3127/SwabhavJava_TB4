package com.aurionpro.mini.project04.OnlineShoppingPlatform;

public class PayPalProcessor extends PaymentProcessor {

	@Override
	public void pay(double amount) {
		System.out.println("Paid " + amount + " using PayPal");

	}

}
