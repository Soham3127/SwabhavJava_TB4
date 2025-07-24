package com.stringBuilder;
import java.util.Scanner;


public class RemoveDigits {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter a String with digits: ");
		String input= scanner.nextLine();
		
		StringBuilder sb= new StringBuilder();
		
		for (char c: input.toCharArray()) {
			if (!Character.isDigit(c)) {
				sb.append(c);
			}
		}
		System.out.println("Output: "+ sb.toString());
		scanner.close();
		
		
	}
	

}
