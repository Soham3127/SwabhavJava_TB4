package com.weekly.assignment01;
import java.util.Scanner;

public class CharacterFrequency {

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        // Input string
	        System.out.print("Enter a string: ");
	        String str = scanner.nextLine().toLowerCase();

	        // Input character
	        System.out.print("Enter a character to count: ");
	        char ch = scanner.next().toLowerCase().charAt(0);

	        int count = 0;

	        // Count occurrences
	        for (int i = 0; i < str.length(); i++) {
	            if (str.charAt(i) == ch) {
	                count++;
	            }
	        }

	        // Output result
	        System.out.println("Frequency of '" + ch + "' is: " + count);

	        scanner.close();
	    }
	}


