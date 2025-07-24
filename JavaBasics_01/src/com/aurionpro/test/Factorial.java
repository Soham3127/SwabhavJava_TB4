package com.aurionpro.test;

public class Factorial {
	
	public static void main (String[] args) {
		
		int num = 7;
		int fact =1 ; 
		for ( int i=1 ; i<=num ; i ++) {
			
			fact=fact*i;
			
		}
		System.out.println( "Factorial of " + num + " is: " +fact);
		
	}
	

}
