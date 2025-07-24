package com.aurionpro.model;

public class Student {
	
	String name;
	int rollno;
	String course;
	
	Student(String name , int rollno, String course){
		
		this.name=name;
		this.rollno=rollno;
		this.course=course;}

	public void displayDetails() {
		System.out.println("-----Student Details----");
		System.out.println("Name of the Student : "+ name );
		System.out.println("Roll No: "+ rollno);
		System.out.println("Course name :" + course);
		System.out.println("--------------");
		 
	}
	}



