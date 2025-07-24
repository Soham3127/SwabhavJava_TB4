package com.aurinopro.polymorphism;

public class BillGenerator {

	public static void bill(String item, int qty) {
		int price = 100;
		int bill = price * qty;
		System.out.println("Total Bill of  " + item + " :"+ bill);
	}

	public static void bill(String item, int qty, double discount) {
		int price = 100;
		double bill = price * qty - discount;
		System.out.println("Total Bill of  " + item + qty+ " :"+ bill);
	}
	
	
	
	public static void bill(String item, int qty, double discount, double tax) {
		int price = 100;
		double bill = price * qty-discount + tax;
		System.out.println("Total Bill of  " + item + " :"+ bill+ "with tax ");}	

	public static void main(String[] args) {
		
		bill("Mouse",500);
		bill("Mouse", 1, 1000);
		bill("Mouse", 1, 1000, 20);
		

	}

}
