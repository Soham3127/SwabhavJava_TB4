package com.weekly.assignment01;
import java.util.Scanner;

public class LongestWord {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        // Input sentence
	        System.out.print("Enter a sentence: ");
	        String sentence = sc.nextLine().trim();

	        // Split into words
	        String[] words = sentence.split("\\s+"); // handles multiple spaces

	        String longest = "";
	        for (String word : words) {
	            if (word.length() > longest.length()) {
	                longest = word;
	            }
	        }

	        // Output result
	        System.out.println("Longest word: " + longest);

	        sc.close();
	    }
	}


