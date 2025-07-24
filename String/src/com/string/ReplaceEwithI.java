package com.string;

import java.util.Scanner;

public class ReplaceEwithI {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter a string : ");
		String original = scanner.nextLine();

		String result = original.replace("e", "i");
		String result1 = result.replace("E", "I");

		System.out.println("Original String :" + original);
		System.out.println("Replaced : " + result1);

	}

}
