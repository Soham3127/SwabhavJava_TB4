package com.aurionpro.array;
import java.util.Scanner;

public class MaxElement {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        // Size of the array 
		System.out.println("Size of the array: ");
		int n = scanner.nextInt();
        
		int[] arr = new int[n];
        // elements in the array 
		System.out.println("Enter the elements: ");
		{
			for (int i = 0; i < n; i++) {
				arr[i] = scanner.nextInt();
			}
         // Find Max Element 
			int max  = 0;

			for (int i = 0; i < n; i++) {
				if (arr[i]> max)
					max=arr[i];
				
			}

			System.out.println("The maximum Element of the array is : " + max);

			scanner.close();

		}

	}

}


