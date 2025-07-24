package com.weekly.assignment01;
import java.util.Scanner;


public class ReverseString {
	public static void main (String [] args){
		
	Scanner scanner = new Scanner(System.in);
	
	System.out.println("Enter a String: ");
	String original= scanner.nextLine();
	
	String reversed="";
	
	for (int i = original.length() - 1; i >= 0; i--) {
        reversed += original.charAt(i);
    }

    System.out.println("Reversed string: " + reversed);
	
	scanner.close();
	
	}

}
