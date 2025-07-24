package com.aurionpro.compare.moviefare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;



public class MovieTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Movie> movies = new ArrayList<>();
       

        int n = 0;
        while (true) {
            try {
                System.out.print("Enter number of movies: ");
                n = sc.nextInt();
                sc.nextLine(); 
                if (n <= 0) {
                    System.out.println(" Number must be greater than 0.");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid integer.");
                sc.nextLine(); 
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.println("\nEnter details for movie " + i + ":");

            // Title validation (only letters and spaces)
            String title;
            while (true) {
                System.out.print("Title: ");
                title = sc.nextLine();
                if (title.matches("[a-zA-Z ]+")) {
                    break;
                } else {
                    System.out.println(" Title should only contain letters and spaces.");
                }
            }

            // Year validation 
            int year = 0;
           int  currentYear=2025;
            while (true) {
                try {
                    System.out.print("Year: ");
                    year = sc.nextInt();
                    sc.nextLine(); 
                    if (year >= 1900 && year <= currentYear) {
                        break;
                    } else {
                        System.out.println("Year must be between 1900 and " + currentYear + ".");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Please enter a valid numeric year.");
                    sc.nextLine(); 
                }
            }

            movies.add(new Movie(title, year));
        }

        System.out.println("\nMovies Before Sorting:");
        for (Movie m : movies) {
            System.out.println(m);
        }

        Collections.sort(movies, new MovieComparator());

        System.out.println("\nMovies After Sorting (Year Desc, Title Asc):");
        for (Movie m : movies) {
            System.out.println(m);
        }

        sc.close();
    }
}
