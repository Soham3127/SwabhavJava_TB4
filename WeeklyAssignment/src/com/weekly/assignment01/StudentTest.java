package com.weekly.assignment01;

import java.util.Scanner;

public class StudentTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Student[] students = new Student[3];

		for (int i = 0; i < 3; i++) {
			System.out.println("Enter the details for the students " + (i + 1));

			System.out.print("Enter the name : ");
			String name = scanner.nextLine();

			System.out.print("Enter the roll number: ");
			int roll = scanner.nextInt();

			int[] marks = new int[3];
			for (int j = 0; j < 3; j++) {
				System.out.print("Enter marks for subject " + (j + 1) + ": ");
				marks[j] = scanner.nextInt();
			}

			scanner.nextLine(); // consume leftover newline

			students[i] = new Student(name, roll, marks);
			System.out.println(); // spacing between students
		}

		// Output loop
		System.out.println("----- Student Details -----");
		for (Student s : students) {
			s.display();
		}

		scanner.close();
	}
}