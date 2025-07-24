package com.aurionpro.compare.candidates;

import java.util.*;

public class CandidateTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Candidate> candidates = new ArrayList<>();

        int n = 0;
        while (true) {
            try {
                System.out.print("Enter number of candidates: ");
                n = sc.nextInt();
                sc.nextLine(); // clear buffer
                if (n <= 0) {
                    System.out.println(" Number must be positive.");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println(" Please enter a valid integer.");
                sc.nextLine(); // clear invalid input
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.println("\nEnter details for Candidate " + i + ":");

            // Validate name
            String name;
            while (true) {
                System.out.print("Name: ");
                name = sc.nextLine();
                if (name.matches("[a-zA-Z ]+")) {
                    break;
                } else {
                    System.out.println("❌ Name must contain only letters and spaces.");
                }
            }

            // Validate age
            int age = 0;
            while (true) {
                try {
                    System.out.print("Age: ");
                    age = sc.nextInt();
                    if (age >= 18 && age <= 60) {
                        break;
                    } else {
                        System.out.println("❌ Age must be between 18 and 60.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("❌ Enter a valid integer for age.");
                } finally {
                    sc.nextLine(); // clear buffer
                }
            }

            // Validate marks
            double marks = 0;
            while (true) {
                try {
                    System.out.print("Marks (0-100): ");
                    marks = sc.nextDouble();
                    if (marks >= 0 && marks <= 100) {
                        break;
                    } else {
                        System.out.println("Marks must be between 0 and 100.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println(" Enter a valid number for marks.");
                } finally {
                    sc.nextLine(); // clear buffer
                }
            }

            candidates.add(new Candidate(name, age));
        }

        System.out.println("\nCandidate List:");
        for (Candidate c : candidates) {
            System.out.println(c);
        }

        sc.close();
    }
}
