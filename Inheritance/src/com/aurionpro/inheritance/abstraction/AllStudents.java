package com.aurionpro.inheritance.abstraction;

public abstract class AllStudents {
	
	public String name;
	 public int rollNumber;
	
	AllStudents (String name , int rollNumber){
		this.name=name;
		this.rollNumber=rollNumber;
	}
	
	public abstract  double calculateGrade();
	
}	
	
	


