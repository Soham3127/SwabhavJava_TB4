package com.string;
import java.util.Scanner;

public class ExtractUsername {
	public static void main(String[] args) {
		
		Scanner scanner= new Scanner(System.in);
		
		System.out.println("Enter you Email ID: ");
		String mail= scanner.nextLine();
		
		
		int atIndex= mail.indexOf('@');
		String username;
		// if atIndex ==-1 @ not found 
		if (atIndex != -1) {
		     username = mail.substring(0, atIndex); // Get part before '@'
		} else {
		    username= mail;
		}
		
		System.out.println("username: "+ username );
		
	}

}
