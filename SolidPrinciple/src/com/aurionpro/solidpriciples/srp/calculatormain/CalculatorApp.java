package com.aurionpro.solidpriciples.srp.calculatormain;

import java.util.Scanner;

import com.aurionpro.solidpriciples.srp.addition.Addition;
import com.aurionpro.solidpriciples.srp.calculatopr.Calculator;
import com.aurionpro.solidpriciples.srp.division.Division;
import com.aurionpro.solidpriciples.srp.input.InputReader;
import com.aurionpro.solidpriciples.srp.multiplication.Multipliaction;
import com.aurionpro.solidpriciples.srp.subtraction.Subtraction;

public class CalculatorApp {
	public static void main(String[] args) {
		InputReader reader = new InputReader();
		Calculator calculator = reader.readInput();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Choose operation: +, -, *, /");
		String op = scanner.next();

		switch (op) {
			case "+":
				Addition add = new Addition();
				System.out.println("Result: " + add.add(calculator));
				break;
			case "-":
				Subtraction sub = new Subtraction();
				System.out.println("Result: " + sub.sub(calculator));
				break;

			case "*":
				Multipliaction mul = new Multipliaction();
				System.out.println("Result: " + mul.multiply(calculator));
				break;

			case "/":
				Division div = new Division();
				try {
					System.out.println("Result: " + div.div(calculator));
				} catch (ArithmeticException e) {
					System.out.println("Error: " + e.getMessage());
				}
				break;

			default:
				System.out.println("Invalid operation.");
		}
	}
}