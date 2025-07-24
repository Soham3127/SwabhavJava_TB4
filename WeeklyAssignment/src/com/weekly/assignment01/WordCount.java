package com.weekly.assignment01;
import java.util.Scanner;

public class WordCount {
	
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        // Input sentence
	        System.out.print("Enter a sentence: ");
	        String sentence = scanner.nextLine().trim(); // remove spaces

	        // Split using space
	        if (sentence.isEmpty()) {
	            System.out.println("Word count: 0");
	        } else {
	            String[] words = sentence.split("\\s+"); // handles multiple spaces
	            System.out.println("Word count: " + words.length);
	        }

	        scanner.close();
	    }
	}

