package com.aurionpro.filehandling;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    private static final String FILE_NAME = "students.txt";
    Scanner sc = new Scanner(System.in);

    public void addStudent() {
        try {
            System.out.print("Enter Roll Number: ");
            int roll = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Marks: ");
            int marks = sc.nextInt();

            FileWriter writer = new FileWriter(FILE_NAME, true);
            writer.write(roll + "," + name + "," + marks + "\n");
            writer.close();

            System.out.println("Student added successfully.\n");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            sc.nextLine(); // Clear buffer
        }
    }

    public void viewAllStudents() {
        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) {
                System.out.println("No student records found.\n");
                return;
            }

            Scanner reader = new Scanner(file);
            System.out.println("All Students:");
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                Student s = Student.fromString(line);
                System.out.println("Roll: " + s.roll + ", Name: " + s.name + ", Marks: " + s.marks);
            }
            reader.close();
            System.out.println();
        } catch (Exception e) {
            System.out.println("Error reading student data.\n");
        }
    }

    public void searchStudentByRoll() {
        System.out.print("Enter Roll Number to search: ");
        int searchRoll = sc.nextInt();
        boolean found = false;

        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) {
                System.out.println("No student records found.\n");
                return;
            }

            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                Student s = Student.fromString(line);
                if (s.roll == searchRoll) {
                    System.out.println("Found: Roll: " + s.roll + ", Name: " + s.name + ", Marks: " + s.marks + "\n");
                    found = true;
                    break;
                }
            }
            reader.close();
            if (!found) {
                System.out.println("Student not found.\n");
            }
        } catch (Exception e) {
            System.out.println("Error during search.\n");
        }
    }

    public void deleteStudentByRoll() {
        System.out.print("Enter Roll Number to delete: ");
        int deleteRoll = sc.nextInt();
        boolean deleted = false;

        ArrayList<String> updatedRecords = new ArrayList<>();

        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) {
                System.out.println("No student records found.\n");
                return;
            }

            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                Student s = Student.fromString(line);
                if (s.roll != deleteRoll) {
                    updatedRecords.add(line);
                } else {
                    deleted = true;
                }
            }
            reader.close();

            FileWriter writer = new FileWriter(FILE_NAME);
            for (String record : updatedRecords) {
                writer.write(record + "\n");
            }
            writer.close();

            if (deleted)
                System.out.println("Student deleted successfully.\n");
            else
                System.out.println("Roll number not found.\n");

        } catch (Exception e) {
            System.out.println("Error while deleting student.\n");
        }
    }
}

