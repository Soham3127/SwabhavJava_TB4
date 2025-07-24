package com.aurionpro.test;

public class SumOfDigit {
	
	public static void main(String[] args) {
	int number = 1234;
	int sum =0;
	 while (number !=0 ) {
		 
		 sum = sum +number%10;
		 
		 number = number /10;
		 
		 
	 }
	 System.out.println("Sum of digits :  " + sum );
}
}
