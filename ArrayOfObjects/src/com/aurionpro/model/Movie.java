package com.aurionpro.model;

public class Movie {
	
	String genere;
	String title;
	
	public Movie (String title, String genere) {
		
		
		this.title=title;
		this.genere=genere;
		}
	
	public void display() {
		
		if(genere.equalsIgnoreCase("Action")){
			System.out.println("The title of all the action Movies are:  "+title );
			
		}
	
		
		
		
	}

}
