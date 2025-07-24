package com.aurionpro.array;

import java.util.Scanner;

public class ReadArray {
	public static void main (String [] args) {
		
		Scanner scanner = new Scanner(System.in);
		//Taking the size of the array
		
	    System.out.println("Enter the size of the array: ");
		int n = scanner.nextInt();
		
		// Declaring the size 
		int [] arr = new int [n];
		
		//Taking the input of elements 
		System.out.println("Enter " + n + " Elements: ");
		for (int i=0 ; i<n ;  i++) {
			arr[i] = scanner.nextInt();
		}
		
		// Displaying them 
		System.out.println("The elemenst in the array are: ");{
			for (int i=0 ; i<n ; i++) {
				System.out.print(arr[i] + " ");
				
			}
				
		}
	}

}
