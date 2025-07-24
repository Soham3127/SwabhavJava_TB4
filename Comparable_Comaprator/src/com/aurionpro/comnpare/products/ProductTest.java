package com.aurionpro.comnpare.products;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ProductTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Product> products = new ArrayList<>();

        int n = 0;

        
        while (true) {
            try {
                System.out.print("Enter number of products: ");
                n = sc.nextInt();
                sc.nextLine(); 
                if (n <= 0) {
                    System.out.println("Number of products must be positive. Try again.");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                sc.nextLine(); 
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.println("\nEnter details for product " + i + ":");

            String category = "";
            while (true) {
                System.out.print("Category: ");
                category = sc.nextLine().trim();
                if (category.isEmpty()) {
                    System.out.println("Category cannot be empty.");
                } else {
                    break;
                }
            }

            String name = "";
            while (true) {
                System.out.print("Name: ");
                name = sc.nextLine().trim();
                if (name.isEmpty()) {
                    System.out.println("Name cannot be empty.");
                } else {
                    break;
                }
            }

            double price = 0.0;
            while (true) {
                try {
                    System.out.print("Price: ");
                    price = sc.nextDouble();
                    sc.nextLine(); 
                    if (price < 0) {
                        System.out.println("Price cannot be negative.");
                    } else {
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid price.");
                    sc.nextLine(); 
                }
            }

            products.add(new Product(category, name, price));
        }

        System.out.println("\nBefore Sorting:");
        for (Product p : products) {
            System.out.println(p);
        }

        
        Collections.sort(products, new ProductComparator());

      
        System.out.println("\nAfter Sorting (by Category, then Price):");
        for (Product p : products) {
            System.out.println(p);
        }

        sc.close();
    }
}
