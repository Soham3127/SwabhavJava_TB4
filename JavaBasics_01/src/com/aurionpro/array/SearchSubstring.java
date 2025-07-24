package com.aurionpro.array;
import java.util.Scanner;


public class SearchSubstring {
	public static void main(String[] args) {
		
		Scanner scanner= new Scanner(System.in);
		
		//Taking input of Main String 
		System.out.println("Enter the main String : ");
		String main = scanner.nextLine().trim().toLowerCase();
		// Taking input of SubString to Search 
		System.out.println("Enter the Sub string: ");
		String sub = scanner.nextLine().toLowerCase();
		
		//Finding Substring in string using .contains
		if (main.contains(sub)) {
			
			System.out.println(" Substring found in main String");}
		
		else {
			System.out.println("Substring not found ");
		}
		
		scanner.close();
	
	}

}
