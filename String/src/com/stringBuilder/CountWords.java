package com.stringBuilder;
import java.util.Scanner;

public class CountWords {
	public static void main (String[] args ) {
		
		Scanner scanner= new Scanner(System.in);
		System.out.print("Enter the String: ");
		String input = scanner.nextLine();
		
		System.out.print("Enter the word to count: ");
		String word = scanner.nextLine();
		
		String[] words = input.split(" ");
		
		int count = 0;
		for( String w: words) {
			if (w.equals(word)) {
				count++;
			}
		}
		System.out.println("Output: " + count);
		scanner.close();
		
		
	}

}
