package com.aurionpro.errorhandling;

import java.util.Scanner;

public class ThrowKeyword {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the marks: ");
		int marks = scanner.nextInt();

		if (marks < 0 || marks > 100) {
			throw new IllegalArgumentException("check the entered marks ");

		} else {
			System.out.println("Valid Marks");
		}

	}

}
