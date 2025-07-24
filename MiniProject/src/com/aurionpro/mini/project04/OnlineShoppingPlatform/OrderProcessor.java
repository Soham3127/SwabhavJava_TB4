package com.aurionpro.mini.project04.OnlineShoppingPlatform;

public class OrderProcessor {
	private IDiscountStratergy discountStratergy;
	private PaymentProcessor paymentProcessor;
	private INotifier notifier;

	public OrderProcessor(IDiscountStratergy discountStratergy, PaymentProcessor paymentProcessor, INotifier notifier) {

		this.discountStratergy = discountStratergy;
		this.paymentProcessor = paymentProcessor;
		this.notifier = notifier;

	}

	public void process(Order order) {
		double discountedAmounty = discountStratergy.applyDiscount(order.getAmount());
		paymentProcessor.pay(discountedAmounty);
		notifier.sendNotification(order);

	}

}
