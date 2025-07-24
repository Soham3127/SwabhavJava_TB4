package com.aurionpro.array;
import java.util.Scanner;


public class PalindromeArray {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter " + n + " numbers:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner .nextInt();
        }

        boolean isPalindrome = true;

        for (int i = 0; i < n / 2; i++) {
            if (arr[i] != arr[n - 1 - i]) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println("Array is a palindrome.");
        } else {
            System.out.println("Array is not a palindrome.");
        scanner.close();
        }
        
    }
}


