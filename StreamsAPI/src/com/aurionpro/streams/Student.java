package com.aurionpro.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Student {
	public String name;
	public int marks;
	
	public Student(String name , int marks) {
		this.name= name ;
		this.marks=marks;
		
		
	}
	
	public String getName() {
		return name;
	}
	public int getMarks() {
		return marks;
	}
	
	public static void main(String[] args) {
		
		List<Student> students = Arrays.asList(
	            new Student("Soham", 85),
	            new Student("Ashu", 90),
	            new Student("Aditya", 50),
	            new Student("Ha", 65),
	            new Student("Mohan", 70)
	        );
	 		
	         //ount how many passed (marks >= 60)
	         long passedCount = students.stream()
	                                  .filter(s -> s.getMarks() >= 60)
	                                  .count();

	        System.out.println("Number of passed students: " + passedCount);
	        System.out.println("---------------");
	        //Student with highest marks
	        
	        Optional<Student> passedCount1=students.stream().max(Comparator.comparing(Student::getMarks));
	        Student topStudent = passedCount1.get();
	        System.out.println("Student with highest marks: " + topStudent.name + ", Marks: " + topStudent.getMarks());
	        
	        
	        
	}
	}
		
	
	
	
	
	
	
	

