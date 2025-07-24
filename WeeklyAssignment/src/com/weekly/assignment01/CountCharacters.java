package com.weekly.assignment01;
import java.util.Scanner;

public class CountCharacters {
	public static void main(String [] args) {
		Scanner scanner= new Scanner(System.in);
		
		System.out.print("Enter the String: ");
		String input= scanner.nextLine();
		
		int letters=0 , digits=0, special=0;
		
		for (int i=0; i<input.length(); i++) {
			char ch = input.charAt(i);
			if (Character.isLetter(ch)) { // used wrapper class Character
				letters++;}
			else if (Character.isDigit(ch)) {
				digits ++;}
				else {
					special++;
				}	
					
		
			}
		
		System.out.println("Letter: "+ letters);
		System.out.println("Digits: "+ digits);
		System.out.println("Special Characters: " + special);
		scanner.close();
			
		}
			
		
		
	}


