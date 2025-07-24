package com.aurionpro.mini.project03.StudentPerformanceSystem;

import java.util.Scanner;

public class StudentManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Student[] students = new Student[5];
        int count = 0;

        while (true) {
            System.out.println("\n-------- Student Performance System --------");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Exit");
            System.out.print("Choose option (1/2/3): ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                if (count >= students.length) {
                    System.out.println("Student limit reached (5 students).");
                    continue;
                }

                System.out.print("Enter Student Name: ");
                String name = scanner.nextLine();

                System.out.print("Enter Roll Number: ");
                int roll = Integer.valueOf(scanner.nextLine());

                System.out.print("Enter Stream (Science/Commerce/Arts): ");
                String stream = scanner.nextLine();

                if (stream.equalsIgnoreCase("Science")) {
                    System.out.print("Enter Physics Marks: ");
                    int p = Integer.valueOf(scanner.nextLine());

                    System.out.print("Enter Chemistry Marks: ");
                    int c = Integer.valueOf(scanner.nextLine());

                    System.out.print("Enter Maths Marks: ");
                    int m = Integer.valueOf(scanner.nextLine());

                    students[count] = new ScienceStudent(name, roll, p, c, m, stream);

                } else if (stream.equalsIgnoreCase("Commerce")) {
                    System.out.print("Enter Accounts Marks: ");
                    int a = Integer.valueOf(scanner.nextLine());

                    System.out.print("Enter Business Marks: ");
                    int b = Integer.valueOf(scanner.nextLine());

                    System.out.print("Enter Economics Marks: ");
                    int e = Integer.valueOf(scanner.nextLine());

                    students[count] = new CommerceStudent(name, roll, a, b, e, stream);

                } else if (stream.equalsIgnoreCase("Arts")) {
                    System.out.print("Enter History Marks: ");
                    int h = Integer.valueOf(scanner.nextLine());

                    System.out.print("Enter Political Science Marks: ");
                    int ps = Integer.valueOf(scanner.nextLine());

                    System.out.print("Enter Sociology Marks: ");
                    int s = Integer.valueOf(scanner.nextLine());

                    students[count] = new ArtsStudent(name, roll, h, ps, s, stream);

                } else {
                    System.out.println("Invalid stream. Please enter Science, Commerce, or Arts.");
                    continue;
                }

                System.out.println("Student Added Successfully.");
                count++;

            }

            else if (choice.equals("2")) {
                if (count == 0) {
                    System.out.println("No students added yet.");
                } else {
                    System.out.println("\n-------- Student Details --------");
                    for (int i = 0; i < count; i++) {
                        students[i].displayInfo();
                        students[i].displayPerformance(true);  
                        System.out.println("----------------------------------------");
                    }
                }
            }

            else if (choice.equals("3")) {
                System.out.println("Exiting the system...");
                break;
            }

            else {
                System.out.println("Invalid Option. Please choose 1, 2, or 3.");
            }
        }

        scanner.close();
    }
}
