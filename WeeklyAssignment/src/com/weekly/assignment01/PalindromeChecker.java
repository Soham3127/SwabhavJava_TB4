package com.weekly.assignment01;

import java.util.Scanner;

public class PalindromeChecker {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Input string
		System.out.print("Enter a string: ");
		String input = scanner.nextLine().toLowerCase(); // Case-insensitive

		boolean isPalindrome = true;

		// Compare characters from both ends
		for (int i = 0; i < input.length() / 2; i++) {
			if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
				isPalindrome = false;
				break;
			}
		}

		// Output result
		if (isPalindrome) {
			System.out.println("This is a Palindrome");
		} else {
			System.out.println("This is not a palindrome");
		}

		scanner.close();
	}
}
