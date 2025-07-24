package com.aurionpro.mini.project02.university;

import java.util.Scanner;

public class University {
    static int totalCourses = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input Students
        System.out.print("Enter number of students: ");
        int studentCount = sc.nextInt();
        sc.nextLine();

        Student[] students = new Student[studentCount];

        for (int i = 0; i < studentCount; i++) {
            System.out.println("\n--- Enter details for Student " + (i + 1) + " ---");

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Roll Number: ");
            int roll = sc.nextInt();
            sc.nextLine();

            Departments dept = chooseDepartment(sc);
            students[i] = new Student(name, roll, dept);

            System.out.print("How many courses to enroll (max 5)?:  ");
            int courseNum = sc.nextInt();
            sc.nextLine();

            for (int j = 0; j < courseNum && j < 5; j++) {
                System.out.print("Enter course " + (j + 1) + ": ");
                String course = sc.nextLine();
                students[i].enrollCourse(course);
                totalCourses++;
            }
        }

        // Input Professors
        System.out.print("\nEnter number of professors: ");
        int professorCount = sc.nextInt();
        sc.nextLine();

        Professor[] professors = new Professor[professorCount];

        for (int i = 0; i < professorCount; i++) {
            System.out.println("\n--- Enter details for Professor " + (i + 1) + " ---");

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            Departments dept = chooseDepartment(sc);
            professors[i] = new Professor(name, id, dept);

            System.out.print("How many subjects to assign (max 5)? ");
            int subjectNum = sc.nextInt();
            sc.nextLine();

            for (int j = 0; j < subjectNum && j < 5; j++) {
                System.out.print("Enter subject " + (j + 1) + ": ");
                String subject = sc.nextLine();
                professors[i].assignSubject(subject);
            }
        }

        // Display All Student Details
        System.out.println("\n===== Student Details =====");
        for (Student s : students) {
            System.out.println(s.getDetails());
        }

        // Display All Professor Details
        System.out.println("\n===== Professor Details =====");
        for (Professor p : professors) {
            System.out.println(p.getDetails());
        }

        // Summary
        System.out.println("\nTotal Students: " + Student.totalStudents);
        System.out.println("Total Courses Enrolled: " + totalCourses);

        sc.close();
    }

    public static Departments chooseDepartment(Scanner sc) {
        Departments[] depts = Departments.values();
        System.out.println("Select Department:");

        for (int i = 0; i < depts.length; i++) {
            System.out.println((i + 1) + ". " + depts[i]);
        }

        int choice = 0;
        while (choice < 1 || choice > depts.length) {
            System.out.print("Enter choice (1-" + depts.length + "): ");
            choice = sc.nextInt();
            sc.nextLine();
        }

        return depts[choice - 1];
    }
}
