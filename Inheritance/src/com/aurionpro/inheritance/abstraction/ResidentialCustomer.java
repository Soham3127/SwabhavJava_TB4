package com.aurionpro.inheritance.abstraction;

public class ResidentialCustomer extends Customer {
	public ResidentialCustomer(String name , int units) {
		super(name , units );
		
	}
	public double calculateBill() {
		return unitsConsumed*5;
	}

}
