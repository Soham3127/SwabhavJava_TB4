package com.aurionpro.filehandling;

public class Student {
    int roll;
    String name;
    int marks;

    public Student(int roll, String name, int marks) {
        this.roll = roll;
        this.name = name;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return roll + "," + name + "," + marks;
    }

    public static Student fromString(String line) {
        String[] parts = line.split(",");
        int roll = Integer.parseInt(parts[0]);
        String name = parts[1];
        int marks = Integer.parseInt(parts[2]);
        return new Student(roll, name, marks);
    }
}
