package com.aurionpro.staticc;

public class Shop {
	static double tax_rate= 0.18;
	
	
	public static void main(String[] args) {
		double price =1000;
		double totalCost= price+(price*tax_rate);
		
		System.out.println("The new price of the goods: " + totalCost);
	}

}
