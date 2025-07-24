package com.aurionpro.mini.project02.university;

public class Person {
	String name;
	Departments department;

	public Person(String name, Departments department) {
		this.name = name;
		this.department = department;

	}

	public String getDetails() {
		return "Name: " + name + " , Departrment: " + department;

	}
}
