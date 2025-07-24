package com.aurionpro.mini.project04.OnlineShoppingPlatform;

public class SMS  implements INotifier{

	@Override
	public void sendNotification(Order order) {
		
		System.out.println("SMS send to " + order.customerName() + " for order " + order.getProductType());
		
		
	}

}
