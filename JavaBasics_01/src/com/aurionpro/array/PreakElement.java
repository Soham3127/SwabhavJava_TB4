package com.aurionpro.array;

import java.util.Scanner;

public class PreakElement {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// Size of the array
		System.out.println("Size of the array: ");
		int n = scanner.nextInt();

		int[] arr = new int[n];
		// elements in the array
		System.out.print("Enter the elements: ");
		{
			for (int i = 0; i < n; i++) {
				arr[i] = scanner.nextInt();
			}
			// Find Peak Element
			for (int i = 0; i < n; i++) {
				// check element on left				        // check element on right
				if ((arr [i] == 0 || arr[i] >= arr[i - 1] )&& ( arr[i] == n - 1 || arr[i] >= arr[i + 1])) {
				System.out.println("The Peak Element  : " + arr[i]);
				break;}

			}

			scanner.close();

		}

	}
}

