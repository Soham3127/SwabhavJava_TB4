package com.stringBuilder;

import java.util.Scanner;

public class ReverseChecker {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter first  string : ");
		String string1 = scanner.nextLine();

		System.out.print("Enter second  string : ");
		String string2 = scanner.nextLine();

		StringBuilder sb = new StringBuilder(string1);
		sb.reverse();

		if (sb.toString().equalsIgnoreCase(string2)) {
			System.out.println("Yes, the strings are reverse of each other");
		} else {
			System.out.println("No, the strings are not reverse of each other");
		}

		scanner.close();

	}

}
