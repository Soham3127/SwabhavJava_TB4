package com.aurionpro.errorhandling;
import java.util.Scanner;

public class TryCatch {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		try {
		System.out.print(" num1: ");
		int num1 = scanner.nextInt();
		System.out.print("num2: ");
		int num2 = scanner.nextInt();
		
		int result = num1/num2;
		System.out.println("Result: " + result);
		
		
		}
		
		catch ( ArithmeticException e) {
			System.out.println(" cannot divide by 0 ");
			
		}
		
		catch (NumberFormatException e) {
            System.out.println("Error: Invalid input. Please enter numeric values.");

        }
		
		catch (Exception e) {
			System.out.println("Message "+ e);
		}
		
		finally {
			System.out.println("Ended.....");
		}
		
	}
	
	
	
	


}
