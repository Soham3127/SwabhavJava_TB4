package com.aurionpro.test;

public class PrimeNumber {
	public static void main (String[] args) {
		
		int num = 7;
		
		for ( int i=2 ; i <=num ; i++  ) {
			
			if (num % i == 0 ) {
				
				System.out.println("This is not a prime number: " + num);
				break;
				}
				else
				{
					System.out.println("This is a prime number:"+ num);}
					break;
				}
		
		
		
		
			}

		}
