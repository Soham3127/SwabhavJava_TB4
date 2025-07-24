package com.aurionpro.filehandling;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentFileManager {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner sc = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("----- Student Record Manager -----");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by Roll Number");
            System.out.println("4. Delete Student by Roll Number");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            try {
                choice = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number.\n");
                sc.next(); // clear buffer
                continue;
            }

            switch (choice) {
                case 1:
                    manager.addStudent();
                    break;
                case 2:
                    manager.viewAllStudents();
                    break;
                case 3:
                    manager.searchStudentByRoll();
                    break;
                case 4:
                    manager.deleteStudentByRoll();
                    break;
                case 5:
                    System.out.println("Exiting program. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.\n");
            }
        }
    }
}
