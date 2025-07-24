package com.aurionpro.interface01;

public class UpiPayment implements IPayment {
	public void processPayment(double amount) {
		System.out.println("UPI Payment: "+ amount);
	}
}
