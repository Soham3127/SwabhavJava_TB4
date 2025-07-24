package com.aurionpro.mini.project04.OnlineShoppingPlatform;

public class Order {
	private String productType;
	private double amount;
	private String customerName;
	private int quantity;
	
	
	public Order(String customerName,String productType, double amount, int quantity) {
		this.customerName=customerName;
		this.productType=productType;
		this.amount=amount;
		this.quantity=quantity;
		
	}
	
	public String customerName() {
		return customerName;
	}
	
	public String getProductType() {
		return productType;
	}
	
	public double getAmount() {
		return amount;
	}
	public int getQuantity() {
		return quantity;
	}
	
	

}
