package com.aurionpro.mini.project02.university;

public class Professor extends Person {
    int id;
    String[] subjects = new String[5];
    int subjectCount = 0;

    public Professor(String name, int id, Departments department) {
        super(name, department);
        this.id = id;
    }

    public void assignSubject(String subjectName) {
        if (subjectCount < subjects.length) {
            subjects[subjectCount] = subjectName;
            subjectCount++;
            System.out.println(name + " assigned to " + subjectName);
        } else {
            System.out.println("Cannot assign more subjects.");
        }
    }

    @Override
    public String getDetails() {
        return "Professor Name: " + name + ", ID: " + id +
                ", Department: " + department + ", Subjects Assigned: " + subjectCount;
    }
}