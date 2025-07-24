package com.aurionpro.solidpriciples.srp.calculatopr;
import java.util.Scanner;

public class Calculator {
	int num1;
	int num2;

	public Calculator(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
	}
	
	
	
	public int getNum1() {
		return num1;
	}
	public int getNum2() {
		return num2;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the first number: ");
		int num1 = scanner.nextInt();

		System.out.println("Enter the secnd  number: ");
		int num2 = scanner.nextInt();

	}
}