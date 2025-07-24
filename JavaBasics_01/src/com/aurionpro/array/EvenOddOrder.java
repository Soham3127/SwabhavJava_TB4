package com.aurionpro.array;
import java.util.Scanner;

public class EvenOddOrder {
	

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        // Input size of array
	        System.out.print("Enter the size of array: ");
	        int n = scanner.nextInt();

	        int[] arr = new int[n];

	        // Input array elements
	        System.out.println("Enter " + n + " numbers:");
	        for (int i = 0; i < n; i++) {
	            arr[i] = scanner.nextInt();
	        }

	        // Rearranging: Even numbers first
	        int[] result = new int[n];
	        int index = 0;

	        // First, add even numbers
	        for (int i = 0; i < n; i++) {
	            if (arr[i] % 2 == 0) {
	                result[index++] = arr[i];
	            }
	        }

	        // Then, add odd numbers
	        for (int i = 0; i < n; i++) {
	            if (arr[i] % 2 != 0) {
	                result[index++] = arr[i];
	            }
	        }

	        // Print result
	        System.out.println("Rearranged Array (Even-Odd):");
	        for (int i = 0; i < n; i++) {
	            System.out.print(result[i] + " ");
	        }
	        scanner.close();
	    }
	}


