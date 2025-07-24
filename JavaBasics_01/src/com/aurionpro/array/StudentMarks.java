package com.aurionpro.array;
import java.util.Scanner;

public class StudentMarks {
	

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        // Take student's name
	        System.out.print("Enter student's name: ");
	        String name = scanner.nextLine();

	        // Create array for 3 subjects
	        int[] marks = new int[3];
	        String[] subjects = {"Math", "Science", "English"};

	        // Input marks
	        for (int i = 0; i < 3; i++) {
	            System.out.print("Enter marks for " + subjects[i] + ": ");
	            marks[i] = scanner.nextInt();
	        }

	        // Print result
	        System.out.println("\nStudent Name: " + name);
	        for (int i = 0; i < 3; i++) {
	            System.out.println(subjects[i] + ": " + marks[i]);
	        }
	    
	}
}


