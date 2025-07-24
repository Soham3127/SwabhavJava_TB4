package com.aurinopro.polymorphism;

public class Volumecalculator {

	public static void volume(int a) {
		System.out.println("Volume of cube  " + a * a * a);
	}

	public static void volume(int b, int c, int d) {
		System.out.println("Volume of cuboid  " + b * c * d);
	}

	public static void volume(double r) {
		System.out.println("Volume of sphere  " + (4 / 3 * 3.14 * r * r * r));
	}

	public static void main(String[] args) {

		volume(3);
		volume(3, 4, 5);
		volume(4);

	}

}
