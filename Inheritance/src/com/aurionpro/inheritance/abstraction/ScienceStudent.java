package com.aurionpro.inheritance.abstraction;

public class ScienceStudent extends AllStudents {
	double physics;
	double chemistry;
	double maths ;
	
	public ScienceStudent(String name , int rollNumber,double physics , double chemistry , double maths ){
		super(name , rollNumber);
		this.chemistry=chemistry;
		this.physics= physics;
		this.maths= maths;
		
	}
	public double calculateGrade() {
		return (physics+ chemistry+ maths)/3.0;
	}

}
