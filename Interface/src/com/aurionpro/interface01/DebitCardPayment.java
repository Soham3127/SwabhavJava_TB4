package com.aurionpro.interface01;

public class DebitCardPayment  implements IPayment{
	public void processPayment(double amount) {
		System.out.println("Debit Card: "+ amount);
		
	}

}
