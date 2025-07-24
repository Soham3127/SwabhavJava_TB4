package com.aurionpro.model;
import java.util.Scanner;

public class ProductTest {
	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
	
		System.out.print("Enter the number of Products: ");
		int numberofProducts= scanner.nextInt();
		
		Product[] product= new Product[numberofProducts];
		
		double grandTotal=0;
		for (int i=0 ;i<numberofProducts; i++) {
			
			System.out.println("Enter the Details of the Product " +(i+1));
			
			scanner.nextLine();
			
			System.out.print("Enter the name of the product: ");
			String name = scanner.nextLine();
			
			//scanner.nextLine();
			
			System.out.print("Enter the Price: ");
			int price= scanner.nextInt();
			scanner.nextLine();
			
			System.out.print("Enter the quantity: ");
			int quantity = scanner.nextInt();
			
			product[i] = new Product(name, price, quantity);
			grandTotal= grandTotal+ product[i].calculateTotal();
			
				
			}
		System.out.println("-----------");
		for(Product p : product) {
			p.display();
			
		}
		System.out.println("Grand Total: " + grandTotal);
		scanner.close();
	}		
}
	
		
	


