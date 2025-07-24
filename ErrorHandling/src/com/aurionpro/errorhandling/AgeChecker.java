package com.aurionpro.errorhandling;
import java.util.Scanner;


public class AgeChecker {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		try {
		System.out.println("Enter age: ");
		int age = scanner.nextInt();
		
		if(age<18) {
			throw new AgeException("Since age is below 18 , hence not allowed");
			
		}
		System.out.println("Elogible to vote ");
	}catch (AgeException e) {
		System.out.println(e);
		
	}
	}
}
