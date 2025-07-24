package com.weekly.assignment01;
import java.util.Scanner;

public class ProductTest {
	public static void main(String[] args) {
		
		Scanner scanner= new Scanner(System.in);
		
		System.out.println("Enter the number of items: ");
		int num= scanner.nextInt();
		scanner.nextLine();
		
		
		Product[] products= new Product[num];
		
		for (int i=0; i<num; i++) {
			System.out.print("Enter the product name: ");
			String name = scanner.nextLine();
			
			System.out.println("Enter the price of the product: ");
			int price = scanner.nextInt();
			
			scanner.nextLine();
			
			products[i] = new Product(name, price);
			
			for (Product p : products) {
				if (p!= null && p.price>1000) {
					p.display();
					
				}
			}
		
			
			
		}
		scanner.close();
		
	}

}
