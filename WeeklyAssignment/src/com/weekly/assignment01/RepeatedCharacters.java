package com.weekly.assignment01;
import java.util.Scanner;

public class RepeatedCharacters {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        String repeated = "";

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (input.indexOf(ch) != input.lastIndexOf(ch) && repeated.indexOf(ch) == -1) {
                repeated += ch;
            }
        }

        System.out.println("Repeated characters: " + repeated);
        scanner.close();
    }


}


	
	
	    