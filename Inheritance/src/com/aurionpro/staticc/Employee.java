package com.aurionpro.staticc;

public class Employee {
	static int count = 0;

	public Employee() {
		count++;
	}

	public static void main(String[] args) {
		Employee n1 = new Employee();
		Employee n2 = new Employee();
		Employee n3 = new Employee();
		Employee n4 = new Employee();
		
		System.out.println("Total Employees Created: "+ Employee.count);
		
	}

}
