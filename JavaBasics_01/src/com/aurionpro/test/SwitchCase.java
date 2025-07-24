package com.aurionpro.test;
import java.util.Scanner;

public class SwitchCase {
	public static void main(String[] args) {
		
		Scanner scanner= new Scanner(System.in);
		
		System.out.println("Enter the number of the month : ");
		int day = scanner.nextInt();
		
		switch (day) {
		
		case 1:
			System.out.println("Month is January and it has 31 days ");
			break;
		case 2:
			System.out.println("Month is February and it has 28/29 days ");
			break;
		case 3:
			System.out.println("Month is March and it has 31 days ");
			break;
		case 4:
			System.out.println("Month is April and it has 30 days ");
			break;
		case 5:
			System.out.println("Month is May and it has 31 days ");	
			break;
		case 6:
			System.out.println("Month is June and it has 30 days ");
			break;
			
		case 7 :
			System.out.println("Month is July and it has 31 days ");
			break;
		case 8:
			System.out.println("Month is August and it has 30 days ");
			break;
		case 9:
			System.out.println("Month is September and it has 31 days ");
			break;
		case 10:
			System.out.println("Month is October  and it has 30 days ");
			break;
			
		case 11:
			System.out.println("Month is November and it has 30 days ");
			break;
		case 12:
			System.out.println("Month is December and it has 31 days ");
			break;	
		
		
		
		
		
		
		
		}
		
	}

}
