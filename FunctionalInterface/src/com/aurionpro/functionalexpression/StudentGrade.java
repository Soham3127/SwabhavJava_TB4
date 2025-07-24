package com.aurionpro.functionalexpression;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class StudentGrade {
	public static void main(String[] args) {

		Function<Integer, String> grade = marks -> {

			if (marks >= 75)
				return "A";
			else if (marks >= 50)
				return "B";
			else
				return "Fail";

		};

		List<Integer> studentmarks = Arrays.asList(88, 62, 49, 44, 69);

		System.out.println("Grades: ");
		for (int i = 0; i < studentmarks.size(); i++) {
			int marks = studentmarks.get(i);
			String grades = grade.apply(marks);

			System.out.println("Student" + (i + 1) + " Marks: " + marks + " Grade: " + grades);

		}

	}

}
