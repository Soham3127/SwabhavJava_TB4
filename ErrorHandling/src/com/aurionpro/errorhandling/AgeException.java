package com.aurionpro.errorhandling;

public class AgeException extends Exception {
	AgeException(){
		System.out.println("Not eligible to vote");
	}
	
	AgeException(String message){
		super(message);
	}

}
