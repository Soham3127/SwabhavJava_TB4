package com.aurionpro.model;

import java.util.Scanner;

public class MovieTest {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the number of movie : ");
		int numberOfMovies = scanner.nextInt();

		Movie[] movies = new Movie[numberOfMovies];

		for (int i = 0; i < numberOfMovies; i++) {

			System.out.println("Enter the Tiltle : ");
			String title = scanner.next();

			System.out.println("Enter the Genere of the movie  : ");
			String genere = scanner.next();

			movies[i] = new Movie(title, genere);

		}
		for (Movie result : movies) {

			result.display();
		}

	}

}
