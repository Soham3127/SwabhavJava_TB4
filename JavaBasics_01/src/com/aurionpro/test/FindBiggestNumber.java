package com.aurionpro.test;

public class FindBiggestNumber {
	public static void main(String[] args) {

		int number1 = 3;
		int number2 = 9;
		int number3 = 6;

		if (number1 > number2 && number1 > number3) {
			System.out.println("Number1 is greater ");
		}

		if (number2 > number1 && number2 > number3) {
			System.out.println("Number 2  is greater ");
		}

		else {
			System.out.println("Number 3  is greater ");
		}

	}
}
