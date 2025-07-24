package com.aurionpro.reflection;

public class Student {
	String name;
	final int rollNo = 8;
	 private double cgpa;

	public Student(String name, int rollNo, double cgpa) {
		this.name = name;
		//this.rollNo = rollNo;
		this.cgpa = cgpa;

	}

	public Student() {

	}

	public String greet() {

		return "Hello";
	}

	public double cgpa() {
		return cgpa;
	}
	
	
	
	
	
	
	

}
