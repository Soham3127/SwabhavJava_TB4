package com.aurionpro.model;

import java.util.Scanner;

public class CircleTest {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the radius: ");
		int radius = scanner.nextInt();

		Circle circle = new Circle(radius);
		System.out.println();
		circle.display();

	}

}

