package com.aurionpro.test;

public class LeapYear {
	
	public static void main (String[] args) {
	
	int year = 2000;
	
	if (year%100 ==0 && year%400== 0) {
		
		System.out.println("This is a leap year ");
	
		{
			if (year%4 == 0  ) 
		
		
				System.out.println("This is a leap year");
		}
	}
	
	else {
		System.out.println("This is not a leap year ");
	}
	

}
}
