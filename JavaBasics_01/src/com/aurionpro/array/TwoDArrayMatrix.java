package com.aurionpro.array;

import java.util.Scanner;

public class TwoDArrayMatrix {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter no of rows ");
		int rows = scanner.nextInt();

		System.out.println("Enter no of columns ");
		int col = scanner.nextInt();

		int[][] matrix = new int[rows][col];
		// input of elements in matrix
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < col; j++) {
				System.out.println("Element [" + i + "[" + j + "]:");
				matrix[i][j] = scanner.nextInt();
			}
		} // print the matrix
		System.out.println("\n The matrix is :");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < col; j++) {
				System.out.println(matrix[i][j] + " ");
			}
			System.out.println();

		}
	}
}
