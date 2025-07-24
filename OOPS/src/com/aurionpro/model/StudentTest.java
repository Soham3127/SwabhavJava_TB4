package com.aurionpro.model;

import java.util.Scanner;

public class StudentTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student[] student = new Student[3];

        for (int i = 0; i < 3; i++) {
            System.out.println("Enter the student details " + (i + 1));

            System.out.print("Enter the name: ");
            String name = scanner.nextLine();

            System.out.print("Enter the roll no: ");
            int rollno = scanner.nextInt();
            scanner.nextLine(); 

            System.out.print("Enter the course name: ");
            String course = scanner.nextLine();

            student[i] = new Student(name, rollno, course);
        }

       
        for (Student s : student) {
            s.displayDetails();
        }

        scanner.close();
    }
}