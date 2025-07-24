package com.aurionpro.functionalexpression;

import java.util.HashMap;
import java.util.function.Predicate;

public class StudentPass {
	public static void main(String[] args) {

		HashMap<Integer, String> marks = new HashMap<>();
		marks.put(33, "Amit");
		marks.put(45, "Soham");
		marks.put(50, "ABC");
		marks.put(40, "WASD");
		marks.put(50, "XYZ");

		Predicate<Integer> isPass = mark -> mark >= 40;
		System.out.println("The students with passing marks: ");
		marks.forEach((mark, name) -> {
			if (isPass.test(mark)) {
				System.out.println(name + " " + mark);

			}

		});

	}

}
