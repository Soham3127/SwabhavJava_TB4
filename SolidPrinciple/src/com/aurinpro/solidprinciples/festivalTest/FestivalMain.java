package com.aurinpro.solidprinciples.festivalTest;

import java.util.Scanner;

import com.aurinpro.solidprinciples.festivalmodel.DiwaliInterest;
import com.aurinpro.solidprinciples.festivalmodel.FixedDeposit;
import com.aurinpro.solidprinciples.festivalmodel.HoliInterest;
import com.aurinpro.solidprinciples.festivalmodel.IFestivalInterest;
import com.aurinpro.solidprinciples.festivalmodel.NyInterest;
import com.aurinpro.solidprinciples.festivalmodel.OtherInterest;

public class FestivalMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		
		System.out.print("Enter the Account Number: ");
		int accountNumber= scanner.nextInt();
		
		System.out.print("Enter the name: ");
		String name = scanner.nextLine();
		
		scanner.nextLine();
		
		System.out.print("Enter the principal amount: ");
		double principal = scanner.nextDouble();
		
		System.out.print("Enter the duration(yrs): ");
		int duration = scanner.nextInt();
		
		System.out.println("Select Festival(Diwali , Holi, Newyear, other): ");
		scanner.nextLine();
		String festival = scanner.nextLine().toUpperCase();
		
		IFestivalInterest interestStrategy;
		
		switch(festival) {
		
		case"DIWALI":
			interestStrategy= new DiwaliInterest();
			break;
		
		case"HOLI":
			interestStrategy= new HoliInterest();
			break;
			
		case"NEWYEAR":
			interestStrategy= new NyInterest();
			break;
		default:
			interestStrategy= new OtherInterest();
			break;
		
		}
		
		FixedDeposit fd = new FixedDeposit(accountNumber, name , principal,duration ,interestStrategy);
		
		System.out.println("Account Holder: " + name);
        System.out.println("Festival Type : " + festival);
        System.out.println("Principal     : " + principal);
        System.out.println("Duration (yrs): " + duration);
        System.out.println("Interest Rate : " +  interestStrategy.getInterestRate()+ "%");
        System.out.println("Total Interest: ₹" + fd.calculateSimpleInterest());

        scanner.close();
	}

}
