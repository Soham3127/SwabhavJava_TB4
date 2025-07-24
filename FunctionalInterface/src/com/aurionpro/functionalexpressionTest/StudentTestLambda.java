package com.aurionpro.functionalexpressionTest;

import com.aurionpro.functionalexpression.IStudent;

public class StudentTestLambda {
	public static void main(String[] args) {
		
		//public void greet {
		
		// LambdaFunction
		
		
		IStudent add = ( a,  b) -> a+b;
		
		
		System.out.println(add.add(5, 7));
	}
	
	

}
