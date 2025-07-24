package com.aurinopro.polymorphism;

import java.util.Scanner;

public class AreaCalculator {

	public static void area(int a) {
		System.out.println("Area of the Square: " + (a * a));

	}

	public static void area(int a, int b) {
		System.out.println("Area of the Rectangle: " + (a * b));
	}

	public static void area(double a) {
		System.out.println("Area of the Rectangle: " + (3.14 * a * a));
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		
		System.out.println("Enter the side of the square: ");
		int a = scanner.nextInt();
		area(a);
		
		System.out.println("Enter the length : ");
		int l = scanner.nextInt();
		System.out.println("Enter the breath : ");
		int b = scanner.nextInt();
		area(l, b );
		
		System.out.println("Enter the radius: ");
		double r = scanner.nextInt();
		area(r);
		scanner.close();
		
		
		
		
		
		
	}
}