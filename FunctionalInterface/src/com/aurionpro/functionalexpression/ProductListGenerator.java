package com.aurionpro.functionalexpression;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class ProductListGenerator {
	public static void main(String[] args) {
		
		Supplier<List<String>> productName = () ->  Arrays.asList(
				"laptop",
				"SmartPhones",
				"Headphones,"
				"Mouse",
				"Monitor");
			
				
		List<String> products = productName.get();
		
		
		System.out.println("Default Products:");
		for (String productName : products) {
			System.out.println(" " + products);
		}
		
	}

}
