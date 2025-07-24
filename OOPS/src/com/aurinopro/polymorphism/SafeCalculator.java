package com.aurinopro.polymorphism;

public class SafeCalculator {

	public static void divide(int a, int b) {
		System.out.println("The remainder: " + (a / b));
		if (b == 0) {
			System.out.println("Invalid");

		}
	}

	public static void divide(double a, double b) {
		System.out.println("The remainder: " + (a / b));
		if (b == 0) {
			System.out.println("Invalid");
		}

	}

	public static void main(String[] args) {
		divide(3, 4);
		divide(3.33, 4.55);

	}

}
