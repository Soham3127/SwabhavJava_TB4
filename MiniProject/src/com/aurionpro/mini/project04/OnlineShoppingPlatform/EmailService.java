package com.aurionpro.mini.project04.OnlineShoppingPlatform;

public class EmailService {
	public void sendOrderConfirmation(Order order) {
		System.out.println("Email send for: " + order.customerName()+ " product" + order.getProductType());
	}

}
