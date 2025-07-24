package com.aurinopro.polymorphism;

public class Attendance {

	void markAttendance() {
		System.out.println("Marked Attendance for all");
	}

	void markAttendance(String name) {
		System.out.println("Mark Attendance for " + name);
	}

	void markAttendance(String[] names) {
		for (String name : names) {
			System.out.println("Mark Attendance for " + name);

		}

	}

	public static void main(String[] args) {
		Attendance a = new Attendance();
		a.markAttendance();
		a.markAttendance("Rohan");
		String[] students = { "Amit", "Neha", "Soham" };
		a.markAttendance(students);

	}

}
