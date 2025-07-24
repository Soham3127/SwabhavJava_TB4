package com.aurionpro.model;

public class Product {
	String name;
	int price;
	int quantity;
	//Constructor
	public Product(String name , int price , int quantity) {
		this.name=name;
		this.price=price;
		this.quantity=quantity;
	}
	//Methods
	
	public double  calculateTotal() {
		return price*quantity;
	}
	
	public void display() {
			
		System.out.println("Product Name: "+ name);
		System.out.println("Price: "+ price);
		System.out.println("Quantity"+ quantity);
		System.out.println("Total Cost: "+ calculateTotal());
		System.out.println("--------------");
		
	}
	
	
	
	
	

}
