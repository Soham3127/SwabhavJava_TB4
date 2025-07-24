package com.aurionpro.errorhandling;

import java.util.Scanner;

public class MultipleCatchBlocks {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String[] s = new String[2];

		System.out.println("Enter elm1: ");
		String elm1 = scanner.nextLine();

		System.out.println("Enter elm2: ");
		String elm2 = scanner.nextLine();
		try {
			System.out.println(s[3]);

			// System.out.println("Length" + s.length);
		}

		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Error " + e);

		}

		catch (NullPointerException e) {
			System.out.println("No values ");
		}

		System.out.println("Length" + s.length);
	}

}
