package com.aurionpro.solidpriciples.srp.input;

import java.util.Scanner;

import com.aurionpro.solidpriciples.srp.calculatopr.Calculator;

public class InputReader {
	public Calculator readInput() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter first number: ");
		int num1 = scanner.nextInt();

		System.out.print("Enter second number: ");
		int num2 = scanner.nextInt();

		return new Calculator(num1, num2);
	}
}