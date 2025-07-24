package com.aurionpro.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Product {
	String product;
	int price;
	
	public Product(String product , int price) {
		this.product= product;
		this.price= price;
		
		
	}
	public String getProduct() {
		return product;
	}
	public int getPrice() {
		return price;
	}
	public String toString() {
		return "Product name: "+ product + " , price: " + price ; 
	}
	
	
	public static void main(String[] args) {
		List<Product> obj = Arrays.asList(
				
				new Product("Mouse" , 600),
				new Product("Monitor" , 400),
				new Product("Keyboard" , 1000),
				new Product("Hardrive" , 700),
				new Product("CPU" , 300),
				new Product("Laptop" , 500)
				);
		
		 obj.stream().filter(p -> p.getPrice()>500).limit(2).collect(Collectors.toList()).forEach(System.out:: println);
		 
	}
}
