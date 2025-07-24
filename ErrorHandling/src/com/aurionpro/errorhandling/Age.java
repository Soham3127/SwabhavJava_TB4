package com.aurionpro.errorhandling;
import java.util.Scanner;

public class Age {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		try {
		System.out.println("Enter your age: ");
		int age = scanner.nextInt();
		
		}
		
		catch(NullPointerException e) {
			System.out.println("Error ");
		}
		
		catch(Exception e) {
			System.out.println(e);
			System.exit(0);// will stop the code further this point even there is catch below
			
			
		}
		//will print reagradless of the try and catch 
		finally {
			System.out.println(" Finall statemenet ");
		}
		
	}

}
