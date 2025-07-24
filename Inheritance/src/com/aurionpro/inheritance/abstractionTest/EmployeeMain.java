package com.aurionpro.inheritance.abstractionTest;
import java.util.Scanner;
import com.aurionpro.inheritance.abstraction.Developer;
import com.aurionpro.inheritance.abstraction.Employee;
import com.aurionpro.inheritance.abstraction.Intern;

public class EmployeeMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("----- Employee Salary Calculator -----");
            System.out.println("1. Calculate Salaries");
            System.out.println("2. Exit");
            System.out.print("Choose: ");
            String choice = sc.nextLine();

            if (choice.equals("2")) {
                break;
            }

            Employee[] employees = new Employee[4];

            for (int i = 0; i <= 2; i++) {
                System.out.println("Enter Developer " + (i + 1) + " details:");
                System.out.print("Name: ");
                String name = sc.nextLine();
                System.out.print("ID: ");
                int id = Integer.valueOf(sc.nextLine());
                System.out.print("Base Salary: ");
                double base = Double.valueOf(sc.nextLine());
                System.out.print("Bonus: ");
                double bonus = Double.valueOf(sc.nextLine());

                employees[i] = new Developer(name, id, base, bonus);
            }

            for (int i = 2; i <=2; i++) {
                System.out.println("Enter Intern " + (i - 1) + " details:");
                System.out.print("Name: ");
                String name = sc.nextLine();
                System.out.print("ID: ");
                int id = Integer.valueOf(sc.nextLine());
                System.out.print("Stipend: ");
                double stipend = Double.valueOf(sc.nextLine());

                employees[i] = new Intern(name, id, stipend);
            }

            System.out.println("\n--- Salaries ---");
            for (Employee emp : employees) {
                System.out.println(emp.name + " Salary: ₹" + emp.calculateSalary());
            }
            System.out.println("----------------------------\n");
        }
        sc.close();
    }
}
