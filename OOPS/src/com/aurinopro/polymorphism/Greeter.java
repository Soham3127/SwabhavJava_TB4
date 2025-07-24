package com.aurinopro.polymorphism;

public class Greeter {

	public  void greet() {
		System.out.println("Hello");
	}

	public  void greet(String name) {
		System.out.println("Hello "+ name  + "!");}

	public static void main(String[] args) {

		Greeter g = new Greeter();


		g.greet();

		g.greet("Soham");

	}

}
