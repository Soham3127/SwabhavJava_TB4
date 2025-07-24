package com.aurionpro.interface01;

import java.util.Scanner;

public class ExamSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        IExamEvaluator[] exams = {
            new TheoryExam(),
            new PracticalExam(),
            new OnlineQuiz()
        };

        String[] examNames = {"Theory Exam", "Practical Exam", "Online Quiz"};
        boolean continueEvaluating = true;

        while (continueEvaluating) {
            String examChoice = "";

            // Validate exam menu input
            while (true) {
                System.out.println("\nSelect which exams to evaluate:");
                System.out.println("1. Theory Exam");
                System.out.println("2. Practical Exam");
                System.out.println("3. Online Quiz");
                System.out.println("4. All Exams");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                examChoice = sc.nextLine().trim();

                if (examChoice.equals("1") || examChoice.equals("2") ||
                    examChoice.equals("3") || examChoice.equals("4") ||
                    examChoice.equals("5")) {
                    break;
                } else {
                    System.out.println("Invalid choice. Please select between 1 and 5.");
                }
            }

            StringBuilder result = new StringBuilder("\n----- Cumulative Evaluation Result -----\n");

            if (examChoice.equals("5")) {
                System.out.println("Exiting...");
                break;
            } else if (examChoice.equals("4")) {
                for (int i = 0; i < exams.length; i++) {
                    String grade = evaluateExam(sc, exams[i], examNames[i]);
                    result.append(examNames[i]).append(": ").append(grade).append("\n");
                }
            } else {
                int index = examChoice.equals("1") ? 0 : examChoice.equals("2") ? 1 : 2;
                String grade = evaluateExam(sc, exams[index], examNames[index]);
                result.append(examNames[index]).append(": ").append(grade).append("\n");
            }

            System.out.println(result);

            // Ask to continue
            while (true) {
                System.out.print("Do you want to evaluate another exam? (yes/no): ");
                String again = sc.nextLine().trim().toLowerCase();
                if (again.equals("yes")) {
                    break;
                } else if (again.equals("no")) {
                    continueEvaluating = false;
                    System.out.println("Exiting... Thank you!");
                    break;
                } else {
                    System.out.println("Invalid input. Please enter yes or no.");
                }
            }
        }

        sc.close();
    }

    // Handles evaluation logic
    private static String evaluateExam(Scanner sc, IExamEvaluator exam, String examName) {
        int marks = -1;

        while (true) {
            System.out.print("Enter " + examName + " marks (0-100): ");
            String input = sc.nextLine().trim();

            if (input.matches("\\d+")) {
                marks = 0;
                for (int i = 0; i < input.length(); i++) {
                    marks = marks * 10 + (input.charAt(i) - '0');
                }
                if (marks >= 0 && marks <= 100) break;
                else System.out.println("Marks must be between 0 and 100.");
            } else {
                System.out.println("Please enter numeric marks (0-100).");
            }
        }

        exam.evaluateMarks(marks);
        return exam.calculateGrade();
    }
}
