package com.weekly.assignment01;
import java .util.Scanner;


public class RemoveDuplicates {
	public static void main (String[] args) {
		
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter a String: ");
		String input = scanner.nextLine();
		String result= "";
		
		for (int i=0 ; i<input.length(); i++) {
			char ch= input.charAt(i);// 
			if (result.indexOf(ch)==-1) {// checks if the character already exist or not 
				result= result+ ch;
			}
			
		}
		 System.out.print("String without the duplicates : "+ result);
		 scanner.close();
		
	}

}
