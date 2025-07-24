package com.aurionpro.inheritance.abstraction;

public abstract class Customer {
	public String name ; 
	 int unitsConsumed;
	
	public Customer(String name , int units){
		this.name=name;
		this.unitsConsumed= units;
		
		
	}
	
	public abstract double calculateBill();
	

}
