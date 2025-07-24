package com.aurinopro.polymorphism;

import java.util.Scanner;

public class Printer {

	public static void print() {
		System.out.println("Default message");

	}

	public static void print(String str) {
		System.out.println("Prints the message: " + str);

	}

	public static void print(int num) {
		System.out.println("Print the number: " + num);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the message:");
		String msg= scanner.nextLine();
		
		System.out.println("Enter a number");
		int num = scanner.nextInt();
		
		
		print();
		print(msg);
		print(num);
		scanner.close();
		

	}

}
