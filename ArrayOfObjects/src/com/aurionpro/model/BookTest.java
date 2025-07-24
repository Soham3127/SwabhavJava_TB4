package com.aurionpro.model;

import java.util.Scanner;

public class BookTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the number of Books: ");
		int numberOfBooks = scanner.nextInt();

		Book[] books = new Book[numberOfBooks];

		for (int i = 0; i < numberOfBooks; i++) {

			System.out.println("Enter the  books ID: ");
			int bookID = scanner.nextInt();
			
			scanner.nextLine();

			System.out.println("Enter the name of books: ");
			String title = scanner.next();

			books[i] = new Book(bookID, title);

		}
		
		for(Book result: books)
		{
			result.display();
		}

	}

}
