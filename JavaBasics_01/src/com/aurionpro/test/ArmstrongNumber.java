package com.aurionpro.test;
import java.util.Scanner;



public class ArmstrongNumber {
	public static void main (String [] args) {
		Scanner scanner = new Scanner (System.in);
		
		System.out.println("Enter a number to check if it is armstrong or not: ");
				
		
		int number= scanner.nextInt();
		int original = number;
		int result =0 ;
		while(number !=0) {
			int digit = number % 10;
			result += digit*digit*digit;
			number = number /10;
			}
		if (original==result) {
			System.out.println("This is a Armstrong Number ");
			} else {
				System.out.println("This is not a Armstrong Number");
			}
		scanner.close();
		
		
		
	}

}
