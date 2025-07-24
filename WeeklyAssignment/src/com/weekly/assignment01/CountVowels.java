package com.weekly.assignment01;

import java.util.Scanner;

public class CountVowels {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		{

			System.out.println("Enter the string: ");
			String original = scanner.nextLine().toLowerCase();

			int count = 0;

			for (int i = 0; i < original.length(); i++) {
				// String to char
				char ch = original.charAt(i);
				if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {

					count++;

				}
		scanner.close();
			}

			System.out.println("The count of vowels in the string are : " + count);
		}
	}
}	