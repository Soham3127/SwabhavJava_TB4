package com.aurionpro.mini.project.PayrollSystem;

class Payroll {
    private Employee[] employees = new Employee[5];
    private int count = 0;

    // Add Employee
    public void addEmployee(Employee emp) {
        if (count < employees.length) {
            employees[count++] = emp;
            System.out.println("Employee added successfully.");
        } else {
            System.out.println("Payroll is full. Cannot add more employees.");
        }
    }

    public void displayAllEmployees1() {
        if (count == 0) {
            System.out.println("No employees in the system.");
            return;
        }
        for (int i = 0; i < count; i++) {
            employees[i].display();
        }
    }

    public void searchByRole1(JobRole role) {
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (employees[i].getRole() == role) {
                employees[i].display();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No employees found with role: " + role);
        }
    }

    // Display All Employees
    public void displayAllEmployees() {
        if (count == 0) {
            System.out.println("No employees in the system.");
            return;
        }
        for (int i = 0; i < count; i++) {
            employees[i].display();
        }
    }

    // Search Employees by Role
    public void searchByRole(JobRole role) {
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (employees[i].getRole() == role) {
                employees[i].display();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No employees found with role: " + role);
        }
    }
}