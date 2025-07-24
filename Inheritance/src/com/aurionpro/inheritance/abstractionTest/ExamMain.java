package com.aurionpro.inheritance.abstractionTest;

import com.aurionpro.inheritance.abstraction.AllStudents;
import com.aurionpro.inheritance.abstraction.CommerceStudent;
import com.aurionpro.inheritance.abstraction.ScienceStudent;


import java.util.Scanner;

public class ExamMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("------Exam Grading System------");
			System.out.println(" 1. Calculate Grade ");
			System.out.println(" 2. Exit the system  ");
			System.out.print("Enter your Choice: ");
			int choice = scanner.nextInt();

			if (choice == 1) {
				// To store students
				AllStudents[] students = new AllStudents[4];
				// Science Students
				for (int i = 0; i < 2; i++) {

					System.out.println("Enter the Science student " + (i + 1) + " details ");
					System.out.print("Enter Name: ");
					String name = scanner.nextLine();
					System.out.print("Enter Roll Number: ");
					int roll =Integer.valueOf(scanner.nextLine());
					System.out.print("Enter Chemistry Marks: ");
					double chem = Double.valueOf(scanner.nextLine());
					System.out.print("Enter Physics Marks: ");
					double phy = Double.valueOf(scanner.nextLine());
					System.out.print("Enter Maths Marks: ");
					double math =Double.valueOf(scanner.nextLine());
					//System.out.print("Total Marks o ");
					

					students[i] = new ScienceStudent(name, roll, chem, phy, math);

				}

				for (int i = 0; i < 2; i++) {

					System.out.print("Enter the Commerce Student " + (i + 1) + " details ");
					System.out.println("Enter Name: ");
					String name = scanner.nextLine();
					System.out.print("Enter Roll Number: ");
					int roll = Integer.valueOf(scanner.nextLine());
					System.out.print("Enter Accounts  Marks: ");
					double acc =Double.valueOf(scanner.nextLine());
					System.out.print("Enter Economics  Marks: ");
					double eco = Double.valueOf(scanner.nextLine());
					System.out.print("Enter Buisness Marks: ");
					double buis = Double.valueOf(scanner.nextLine());

					students[i] = new CommerceStudent(name, roll, acc, eco, buis);

				}
				System.out.println("------Grades-------");
				for (AllStudents s : students) {

					double avg = s.calculateGrade();
					String grade;
					if (avg >= 80) {
						grade = "A";
					} else if (avg >= 60) {
						grade = "B";
					} else {
						grade = "C";
					}

					System.out.println(s.name + ("Roll  Number" + s.rollNumber) + " Average:" + s.calculateGrade()
							+ " Grade:" + grade);

				}
			} else if (choice == 2) {
				System.out.println("Exiting the system");
				break;
			} else {
				System.out.println("Invalid Option!! Enter a valiod option ");
			}

		}
		scanner.close();
	}
}
