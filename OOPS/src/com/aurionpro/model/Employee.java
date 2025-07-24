package com.aurionpro.model;

public class Employee {
	String name;
	int id;
	double basicSalary;

	public Employee(String name, int id, double basicSalary) {
		this.name = name;
		this.id = id;
		this.basicSalary = basicSalary;

	}

	public void generateSalarySlip() {
		double hra = 0.20 * basicSalary;
		double da = 0.10 * basicSalary;
		double totalSalary = basicSalary + hra + da;

		System.out.println("-----Salary Slip------");
		System.out.println("Name of the Employee"+ name);
		System.out.println("Baisc Salary " + basicSalary);
		System.out.println("HRA(20%) " + hra);
		System.out.println("DA(10%)" + da);
		System.out.println("Total Salary: " + totalSalary);

	}

}


