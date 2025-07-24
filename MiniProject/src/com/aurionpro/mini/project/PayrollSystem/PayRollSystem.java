package com.aurionpro.mini.project.PayrollSystem;

import java.util.Scanner;

public class PayRollSystem {
	public class EmployeePayrollSystem {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			Payroll payroll = new Payroll();

		    boolean running = true;

		    while (running) {
		        System.out.println("\n===== Employee Payroll System =====");
		        System.out.println("1. Add Employee");
		        System.out.println("2. Display All Employees with Bonus");
		        System.out.println("3. Search Employees by Job Role");
		        System.out.println("4. Exit");
		        System.out.print("Enter your choice: ");
		        String choice = sc.nextLine();

		        switch (choice) {
		            case "1":
		                System.out.print("Enter Employee ID: ");
		                String id = sc.nextLine();

		                System.out.print("Enter Name: ");
		                String name = sc.nextLine();

		                System.out.print("Enter Salary: ");
		                String salary = sc.nextLine();

		                System.out.println("Select Job Role:");
		                for (JobRole r : JobRole.values()) {
		                    System.out.println("- " + r);
		                }
		                System.out.print("Enter Role: ");
		                String roleInput = sc.nextLine().toUpperCase();

		                JobRole role = null;
		                try {
		                    role = JobRole.valueOf(roleInput);
		                } catch (IllegalArgumentException e) {
		                    System.out.println("Invalid role! Employee not added.");
		                    break;
		                }

		                Employee emp = new Employee(id, name, salary, role);
		                payroll.addEmployee(emp);
		                break;

		            case "2":
		                payroll.displayAllEmployees();
		                break;

		            case "3":
		                System.out.println("Enter Role to Search:");
		                String searchRole = sc.nextLine().toUpperCase();
		                try {
		                    JobRole r = JobRole.valueOf(searchRole);
		                    payroll.searchByRole(r);
		                } catch (IllegalArgumentException e) {
		                    System.out.println("Invalid role input.");
		                }
		                break;

		            case "4":
		                System.out.println("Exiting system. Goodbye!");
		                running = false;
		                break;

		            default:
		                System.out.println("Invalid choice! Enter between 1 to 4.");
		        }
		    }

		    sc.close();
		}
	}
}
