package com.aurionpro.model;

class Student1 {
	String name;
}

public class StudentDemo {
	public static void changeName(Student s ) {
		s.name="Anjali";
		s= new Student1();
		s.name="Riya";
		
		
	}
	
	public static void main (String[] args) {
		Student s1 = new Student1();
		s1.name="Amit";
		
		changeName(s1);
		System.err.println("Name"+ s1.name);
	}

}
