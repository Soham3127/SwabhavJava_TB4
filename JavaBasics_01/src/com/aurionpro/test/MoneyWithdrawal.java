package com.aurionpro.test;

import java.util.Scanner;

public class MoneyWithdrawal {
	public static void main (String[] args) {
		Scanner scanner = new Scanner(System.in);
		//validation
		System.out.println("Type the amount to withdraw: " );
		int Amount= scanner.nextInt();
		
		if (Amount>50000){
			System.out.println("Enter the amount below 50,000");
			
		}
		
			else if (Amount %100 !=0 ){ // to check if the amount is divisible by 100
				System.out.println("The amount should be a multiple of 100");}
			else
				{
				 
				 int Count2000 = Amount/2000; //Count no of 2000
				 Amount= Amount%2000;
				 
				 
				 int Count500 = Amount/500; //Count no of 500
				 Amount= Amount%500;
				 
				 int Count200 = Amount/200; //Count no of 200
				 Amount= Amount%200;
				 
				 int Count100 = Amount/100;  //Count no of 100
				 Amount= Amount%100;
				 
				 if (Count2000>0);{
					 System.out.println("Two Thousand: " + Count2000);}
					 
				if (Count500>0);{
					System.out.println("Five Hundred: " + Count500);}
					
				if (Count200>0);{
					 System.out.println("Two Hundred: "+ Count200);}
				
				if (Count100>0);{
					 System.out.println("One Hundred: " +Count100);			 
					 
				 }
				 	
				 
				 
				 
			 }
			
			
		
		
		}
		
		
		
	}
