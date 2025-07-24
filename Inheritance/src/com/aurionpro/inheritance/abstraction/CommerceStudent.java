package com.aurionpro.inheritance.abstraction;

public class CommerceStudent extends AllStudents {
	double accounts, economics, buisness;
	
	public CommerceStudent(String name , int rollNumber,double accounts , double economics , double buisness){
		super(name , rollNumber);
		this.accounts=accounts;
		this.economics= economics;
		this.buisness= buisness;
		
		
	}
	public double calculateGrade() {
		return (accounts+ economics+ buisness)/3.0;
	}

}