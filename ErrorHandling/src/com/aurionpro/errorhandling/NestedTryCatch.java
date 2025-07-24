package com.aurionpro.errorhandling;

import java.util.Scanner;

public class NestedTryCatch {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String[] patients = new String[3];

		System.out.println("Enter the patient name: ");
		String name = scanner.nextLine();

		try {
			System.out.println("a number to divide 100 with: ");
			int num = scanner.nextInt();

			int result = 1000 / num;
			System.out.println("Result " + result);

			try {
				patients[4] = name;
				System.out.println("Patient to store at pos4: " + patients[4]);

			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Inner catch ");
				System.out.println("Error: " + e);

			}

			catch (ArithmeticException e) {
				System.out.println("Outer catch");
				System.out.println("Error" + e);

			}

			} finally {
				System.out.println("----------");
	
				
				scanner.close();

		}
	}
}