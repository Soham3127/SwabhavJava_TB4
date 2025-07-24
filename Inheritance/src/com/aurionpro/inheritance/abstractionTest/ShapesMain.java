package com.aurionpro.inheritance.abstractionTest;

import java.util.Scanner;

import com.aurionpro.inheritance.abstraction.Circle;
import com.aurionpro.inheritance.abstraction.Shape;
import com.aurionpro.inheritance.abstraction.Square;
import com.aurionpro.inheritance.abstraction.Triangle;

public class ShapesMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("-----Shape Drawing System-----");
			System.out.println("1. Draw shapes ");
			System.out.println("2. Exit the system");
			System.out.print("Choose option (1/2): ");
			String choose = scanner.nextLine();

			if (choose.equals("1")) {

				Shape[] shapes = new Shape[3];
				shapes[0] = new Circle();
				shapes[1] = new Triangle();
				shapes[2] = new Square();

				System.out.println("-----Drawing Shapes -----");
				for (Shape s : shapes) {
					s.draw();
				}
				System.out.println("------------------");

			}
			else if (choose.equals("2")) {
				System.out.println("Exiting.....");
				break;
			} 
			else {
				System.out.println("Invalid input !! Chose between 1 and 2 ");
			}

		}
		

	}

}
