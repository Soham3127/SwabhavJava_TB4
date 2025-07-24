package com.aurionpro.testing;

public class Calculator {
	public double add(double num1, double num2 ) {
		double sum = num1+ num2;
		
		return sum;
		
	}
	
	public double sub(double num1, double num2 ) {
		double sub = num1-  num2;
		
		return sub;
		
	}
	
	public double div(double num1, double num2) {
	    if (num2 == 0) {
	        throw new ArithmeticException("Cannot divide by zero");
	    }
	    return num1 / num2;
	}

	
		
	}


