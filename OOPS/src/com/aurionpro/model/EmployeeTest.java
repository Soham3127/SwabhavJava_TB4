package com.aurionpro.model;
import java.util.Scanner;




public class EmployeeTest {
	public static void main (String[] args) {
		
		Scanner scanner= new Scanner(System.in);
		
		Employee [] employees = new Employee[2];
		

		for (int i = 0; i < 2; i++) {
			System.out.println("Enter the details for the employees " + (i + 1));

			System.out.print("Enter the name : ");
			String name = scanner.nextLine();

			System.out.print("Enter the ID: ");
			int id = scanner.nextInt();
			
			scanner.nextLine();
			
			System.out.println("Enter the Basic Salary: ");
			double basicSalary= scanner.nextInt();
			
			scanner.nextLine();
			
			employees[i]= new Employee(name, id , basicSalary);
			
			for (Employee emp : employees) {
				if (emp != null) {
					emp.generateSalarySlip();}
				}
			}
		scanner.close()	;
			
	}

}

