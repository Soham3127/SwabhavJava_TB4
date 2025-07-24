package com.aurionpro.staticc;

public class Student {
	String name;
	static String college= "XYZ College";
	
	public Student (String name) {
		this.name=name;
	}
	public void display() {
		System.out.println("Name: "+ name + "  College: "+ college);
		
	}
	public static void main(String[] args) {
		Student s1 = new Student("Soham");
		Student s2= new Student ("Rohan");
		
		s1.display();
		s2.display();
	}

}
