package com.aurionpro.mini.project03.StudentPerformanceSystem;

public abstract class Student {
    String name;
    int rollNumber;
    String stream;

    public Student(String name, int rollNumber, String stream) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.stream = stream;
    }

    public void displayInfo() {
        System.out.println("Name: " + name + " | Stream: " + stream + " | Roll No: " + rollNumber);
    }

    // Grade Logic
    public String getGrade() {
        double avg = calculatePerformance();
        if (avg >= 85) return "A";
        else if (avg >= 70) return "B";
        else if (avg >= 55) return "C";
        else if (avg >= 40) return "D";
        else return "F";
    }

    public abstract double calculatePerformance();
    
    public void displayPerformance() {
        System.out.println("Performance: " + calculatePerformance() + "%");
        System.out.println("Grade: " + getGrade());
    }

    public void displayPerformance(boolean detailed) {
        if (detailed) {
            showMarks();
            System.out.println("Average: " + calculatePerformance() + "%");
            System.out.println("Grade: " + getGrade());
        } else {
            displayPerformance();
        }
    }

    public  abstract void showMarks();
}
