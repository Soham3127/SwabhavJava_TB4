package com.aurinopro.polymorphism;

public class Converter {
	
	public static void temp(double a) {
		System.out.println("Temp in Fahrenheit: " + (a*9/5+32));
		
	}
	public static void temp(String scale, double b ) {
		System.out.println("Enter the Scale  " + scale);
		
		System.out.println("Enter the temp: "+ b );
		
	}
	
	
	public static void main(String[] args) {
		
		temp(3.14);
		temp("Celcius", 50);
	

	}

}
