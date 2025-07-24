package com.aurionpro.model;

import java.util.Scanner;

public class EmployeeTest {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the number of employees: ");
		int numberOfEmployee = scanner.nextInt();

		Employee employes = new Employee (numberOfEmployee);

		for (int i = 0; i < numberOfEmployee; i++) {

			System.out.print("Enter the Employee ID :");
			int id = scanner.nextInt();

			System.out.print("Enter the Employee Name: ");
			String name = scanner.nextLine();

			System.out.println("Enter the department name : ");
			String department = scanner.nextLine();

			System.out.println("Enter The Salary: ");
			int salary = scanner.nextInt();

			employes[i] = new Employee(id, name, department, salary);

		}
		
		for (Employee : result employes) {
			result.display();
			
			
		}

	}

}
