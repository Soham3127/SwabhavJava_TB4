package com.aurionpro.comnpare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;



public class StudentTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        // Sample data
        students.add(new Student(101, "Amit"));
        students.add(new Student(102, "Zara"));
        students.add(new Student(103, "Raj"));
        students.add(new Student(103, "Soham"));

        // User choice
        System.out.println("Choose Sorting Criteria:");
        System.out.println("1. Sort by ID");
        System.out.println("2. Sort by Name");
        System.out.print("> ");
        int sortField = sc.nextInt();

        System.out.println("Choose Order:");
        System.out.println("1. Ascending");
        System.out.println("2. Descending");
        System.out.print("> ");
        int sortOrder = sc.nextInt();

        Comparator<Student> comparator = null;

        if (sortField == 1) {
            comparator = (sortOrder == 1) ? new IDAscComparator() : new IDDescComparator();
        } else if (sortField == 2) {
            comparator = (sortOrder == 1) ? new NameAscComparator() : new NameDescComparator();
        } else {
            System.out.println("Invalid sorting field.");
            return;
        }

        Collections.sort(students, comparator);

        for (Student s : students) {
            System.out.println(s);
        }

        sc.close();
    }
}
