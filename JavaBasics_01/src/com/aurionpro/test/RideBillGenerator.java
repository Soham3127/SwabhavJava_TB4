package com.aurionpro.test;
import java.util.Scanner;

public class RideBillGenerator {
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("Height: ");
	        int UserHeight = scanner.nextInt();

	        if (UserHeight < 120) {
	            System.out.println("User is ineligible to Ride");
	            return;
	        }

	        System.out.print("Age: ");
	        int Age = scanner.nextInt();
	        int UserBill = 0;

	        if (Age < 12)
	            UserBill = 5;
	        else if (Age <= 17)
	            UserBill = 7;
	        else if (Age <= 45)
	            UserBill = 9;
	        else if (Age <= 55)
	            UserBill = 0;

	        System.out.println("Do you need photos? (yes/no): ");
	        String Choice = scanner.next();

	        if (Choice.equalsIgnoreCase("yes")) {
	            UserBill += 3;
	        }

	        System.out.println("The total Bill is : $ " + UserBill);
	        scanner.close();
	    }

}
	
	

				
			
					
		
		
				
			
			
			
		
			
		
		
		
		
		
		
		
	
	


