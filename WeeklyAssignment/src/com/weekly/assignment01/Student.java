package com.weekly.assignment01;

public class Student {
	String name;
	int roll;
	int[] marks = new int[3];

	Student(String name, int roll, int[] marks) {
		this.name = name;
		this.roll = roll;
		this.marks = marks;
	}

	void display() {
		System.out.println("Name: " + name);
		System.out.println("Roll No: " + roll);
		System.out.println("Marks in 3 subjects:");
		for (int i = 0; i < 3; i++) {
			System.out.println("Subjects" + (i + 1) + ":" + marks[i]);}
		System.out.println();}
	
}
