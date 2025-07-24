package com.aurionpro.test;

public class MethodWithParamenters {
	public static void add(int a , int b) {
		int sum = a+b;
		System.out.println("The sum is : " + sum);
		
	}
	
	public static void main(String[] args) {
		
		add(20,50);
	}
	
	public static void greet ( String username ) {
		System.out.println("Hello," + username);
		
	}
		greet("Soham");

}
