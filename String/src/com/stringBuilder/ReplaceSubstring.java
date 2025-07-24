
package com.stringBuilder;

import java.util.Scanner;

public class ReplaceSubstring {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the string: ");
		String input = scanner.nextLine();

		System.out.println("Enter the words to replace : ");
		String word = scanner.nextLine();

		System.out.println("Enter the new word : ");
		String replacement = scanner.nextLine();

		StringBuilder sb = new StringBuilder(input);
		int index = sb.indexOf(word);

		if (index != -1) {
			sb.replace(index, index + word.length(), replacement);

		}
		System.out.println("Output: " + sb.toString());
		scanner.close();

	}

}
