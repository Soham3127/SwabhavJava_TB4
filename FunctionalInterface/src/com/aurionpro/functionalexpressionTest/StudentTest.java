package com.aurionpro.functionalexpressionTest;

import com.aurionpro.functionalexpression.IStudent;

public class StudentTest {
	public static void main(String[] args) {
		// Anonymous Function
		IStudent student = new IStudent() {

			@Override
			public void greet() {
				System.out.println("Hello, Soham");

			}

		};
		student.greet();

	}

}
