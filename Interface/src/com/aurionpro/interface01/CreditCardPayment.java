package com.aurionpro.interface01;

public class CreditCardPayment implements IPayment {
	public void processPayment(double amount) {
		System.out.println("Credit Card payment:" + amount);
	}

}
