package com.aurionpro.array;

import java.util.Scanner;

public class SecondMax {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the size of array: ");
		int n = scanner.nextInt();
		int[] arr = new int[n];

		System.out.print("Enter the elements : ");

		for (int i = 0; i < n; i++) {

			arr[i] = scanner.nextInt();
		}
		// Array can store negative element , this make the initial vale the minimum
		int max = Integer.MIN_VALUE;
		int secondmax = Integer.MIN_VALUE;
		// for each loop search each and every element in array
		for (int num : arr) {
			if (num > max) {

				secondmax = max;
				max = num;
			} if (num > secondmax && num != max) {
				secondmax = num;
				 if (secondmax == Integer.MIN_VALUE) {
					System.out.println("There is no Second Max Element");

				}
			}

		}

		System.out.println("The SecondMax Element of the array is :  " + secondmax);
		scanner.close();

	}

}
