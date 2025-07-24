package com.aurinopro.polymorphism;

public class StudentEvaluator {


	    void evaluate(int marks) {
	        if (marks >= 90) {
	            System.out.println("Excellent");
	        } else {
	            System.out.println("Keep Improving");
	        }
	    }

	    String evaluate(int marks, int totalMarks) {
	        double percent = (marks * 100.0) / totalMarks;
	        if (percent >= 90) 
	        	return "A";
	        else if (percent >= 75) 
	        	return "B";
	        else 
	        	return "C";
	    }

	    String evaluate(String grade) {
	        switch (grade) {
	            case "A": 
	            	return "Very Good";
	            case "B":
	            	return "Good";
	            default:
	            	return "Needs Improvement";
	        }
	    }

	    public static void main(String[] args) {
	        StudentEvaluator se = new StudentEvaluator();
	        se.evaluate(92); 
	        String grade = se.evaluate(80, 100); 
	        System.out.println("Grade: " + grade);
	        System.out.println("Evaluation: " + se.evaluate(grade)); 
	    }
	}


