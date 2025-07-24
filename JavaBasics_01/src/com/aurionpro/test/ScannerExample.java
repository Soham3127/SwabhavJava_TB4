package com.aurionpro.test;
import java.util.Scanner;



public class ScannerExample {
	public static void main (String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Name : ");
		String username = scanner.nextLine();
		
		
		System.out.println("Enter your age : ");
		int age = scanner.nextInt();
		
		
		System.out.println("My name is " + username + "," + age);
		
		
		
	}

}
