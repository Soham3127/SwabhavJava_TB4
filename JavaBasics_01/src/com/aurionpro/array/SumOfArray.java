package com.aurionpro.array;

import java.util.Scanner;

public class SumOfArray {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        // Size of the array 
		System.out.println("Size of the array: ");
		int n = scanner.nextInt();
        
		int[] arr = new int[n];
        // elements to add 
		System.out.println("Enter the elements to add : ");
		{
			for (int i = 0; i < n; i++) {
				arr[i] = scanner.nextInt();
			}
         // Addition 
			int sum = 0;

			for (int i = 0; i < n; i++) {
				sum = sum + arr[i];
			}

			System.out.println("Sum of the elements are : " + sum);

			scanner.close();

		}

	}

}
