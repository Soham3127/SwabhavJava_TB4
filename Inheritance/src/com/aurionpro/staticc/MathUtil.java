package com.aurionpro.staticc;

public class MathUtil {
	public static int add(int a, int b) {
		return a + b;
	}

	public static int subtract(int a, int b) {
		return a - b;
	}

	public static int multiply(int a, int b) {
		return a * b;
	}

	public static void main(String[] args) {
		System.out.println("Addition: " + MathUtil.add(10, 30));
		System.out.println("Addition: " + MathUtil.subtract(50, 40));
		System.out.println("Prfoduct: " + MathUtil.multiply(5, 6));
	}

}
