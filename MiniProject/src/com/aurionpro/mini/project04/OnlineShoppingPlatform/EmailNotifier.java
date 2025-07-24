package com.aurionpro.mini.project04.OnlineShoppingPlatform;

public class EmailNotifier implements INotifier {

	@Override
	public void sendNotification(Order order) {
		System.out.println("Email send to " + order.customerName() + " for order of  " + order.getProductType());

	}

}
