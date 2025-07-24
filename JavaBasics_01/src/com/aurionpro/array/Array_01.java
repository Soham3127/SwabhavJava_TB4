package com.aurionpro.array;
import java.util.Scanner;



public class Array_01 {
	public static void main (String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter the size of the array: ");
		int size = scanner.nextInt();
		
		
		int[] marks = new int [size];
		for ( int i=0 ; i<marks.length; i++ ) {
			System.out.println("Enter the value for "+ i + "index");
			
		}
		System.out.println("You enterred");
		for (int i=0 ; i< marks.length ;i++) {
			
			System.out.println("value of " + i + "index: " + marks[i]);
		}
		 scanner.close();
		
		
		
		
		
		
		
		
		
	}

}
