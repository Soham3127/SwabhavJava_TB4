package com.aurionpro.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Student1 {
	String name;
	int marks;

	public Student1(String name, int marks) {

		this.name = name;
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Name: " + name + "| Marks: " + marks;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		List<Student1> students = new ArrayList<>();

		System.out.println("Enter numbers of students:");
		int numOfstudents = scanner.nextInt();

		for (int i = 0; i < numOfstudents; i++) {

			System.out.println("Enter name " + (i + 1) + " :");
			String name = scanner.next();

			System.out.println("Enter the marks: ");
			int marks = scanner.nextInt();

			students.add(new Student1(name, marks));

		}
		System.out.println("------------------------------------");
		
		System.out.println("Students compared with therir marks (Asc):");
		students.stream().sorted(Comparator.comparingInt(s -> s.marks)).forEach(System.out::println);
		
		
		System.out.println("Students sorted with therir name (Ascending):   ");
		students.stream().sorted(Comparator.comparing(n->n.name)).forEach(System.out::println);

		scanner.close();
	}

}
