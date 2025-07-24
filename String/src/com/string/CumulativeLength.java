package com.string;

import java.util.Scanner;

public class CumulativeLength {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the  number of Strings: ");
		int n = scanner.nextInt();

		scanner.nextInt();

		String[] strings = new String[n];
		int totalLength = 0;

		System.out.println("Enter " + n + " strings :");
		for (int i = 0; i < n; i++) {
			strings[i] = scanner.nextLine();
			totalLength = totalLength + strings[i].length();

		

		}

		System.out.println("Cumulative length of the string : " + totalLength);

	}

}


