package com.stringBuilder;

import java.util.Scanner;

public class RemoveSpaces {
	public static void main(String[] args) {
		Scanner scanner =new  Scanner(System.in);
		
		System.out.print("Enter a String: ");
		String input= scanner.nextLine();
		
		StringBuilder sb = new StringBuilder();
		
		for(char c: input.toCharArray()) {
			
			if (c!= ' ') {
				
				sb.append(c);
			}
		}
		System.out.println("Output: "+ sb.toString());
		scanner.close();
		
	}

	
	}
	

