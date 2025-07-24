package com.aurionpro.inheritance.abstraction;

public class CommercialCustomer extends Customer {
	public CommercialCustomer(String name, int units) {
		super(name, units);

	}

	public double calculateBill() {
		return unitsConsumed * 8;
	}

}
