package com.aurinopro.polymorphism;


public class Adder {

	public static void add(int a, int b) {
		System.out.println("Adding two integers" + (a + b));
	}

	public static void add(double a, double b) {
		System.out.println("Adding two integers(double)" + (a + b));
	}

	public static void add(int a, int b, int c) {
		System.out.println("Adding two integers(double)" + (a + b + c));
	}

	public static void main(String[] args) {
		add(3, 4);
		add(5, 6);
		add(3, 4, 5);
	}

}
