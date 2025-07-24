package com.aurionpro.compare.flightfare;

import java.util.*;

public class FlightTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Flight> flights = new ArrayList<>();

        int n = 0;
        while (true) {
            try {
                System.out.print("Enter number of flights: ");
                n = sc.nextInt();
                sc.nextLine(); // clear buffer
                if (n <= 0) {
                    System.out.println(" Number must be greater than 0.");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid integer.");
                sc.nextLine(); // clear wrong input
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.println("\nEnter details for flight " + i + ":");

            // Airline name validation (only letters and spaces)
            String airline;
            while (true) {
                System.out.print("Airline Name: ");
                airline = sc.nextLine();
                if (airline.matches("[a-zA-Z ]+")) {
                    break;
                } else {
                    System.out.println("❌ Airline name must contain only letters and spaces.");
                }
            }

            // Fare validation
            double fare = 0;
            while (true) {
                try {
                    System.out.print("Fare: ");
                    fare = sc.nextDouble();
                    sc.nextLine(); 
                    if (fare <= 0) {
                        System.out.println("Fare must be greater than 0.");
                    } else {
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("❌ Please enter a valid number for fare.");
                    sc.nextLine(); 
                }
            }

            flights.add(new Flight(airline, fare));
        }

        System.out.println("\nFlights Before Sorting:");
        for (Flight f : flights) {
            System.out.println(f);
        }

        Collections.sort(flights, new FareDescComparator());

        System.out.println("\n Flights After Sorting by Fare (Descending):");
        for (Flight f : flights) {
            System.out.println(f);
        }

        sc.close();
    }
}
