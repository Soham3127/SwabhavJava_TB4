package com.aurionpro.staticc;

public class Example {
	public static void showStatic() {
		System.out.println("Static method Called");
	}
	public  void showNonStatic() {
		System.out.println(" Non-Static method Called");
	}
	public static void main(String[] args) {
		Example.showStatic();
		
		Example example = new Example();
		example.showNonStatic();
		
	}

}
