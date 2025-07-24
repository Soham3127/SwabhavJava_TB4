package com.aurionpro.model;

public class Circle {
	int radius;

	public Circle(int radius) {
		this.radius = radius;
	}
	
	public double calculateArea() {
		return 3.14 * radius* radius;
	}
	public void display() {
		double area= calculateArea();
		System.out.println("Area of the circle: "+ area);
	}
	
	}



