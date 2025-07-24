package com.aurionpro.mini.project02.university;

public class Student extends Person {
    int rollNumber;
    String[] courses = new String[5];
    int courseCount = 0;

    static int totalStudents = 0;

    public Student(String name, int rollNumber, Departments department) {
        super(name, department);
        this.rollNumber = rollNumber;
        totalStudents++;
    }

    public void enrollCourse(String courseName) {
        if (courseCount < courses.length) {
            courses[courseCount] = courseName;
            courseCount++;
            University.totalCourses++;
            System.out.println(name + " enrolled in " + courseName);
        } else {
            System.out.println("Cannot enroll in more courses.");
        }
    }

    @Override
    public String getDetails() {
        return "Student Name: " + name + ", Roll No: " + rollNumber +
                ", Department: " + department + ", Courses Enrolled: " + courseCount;
    }
}
