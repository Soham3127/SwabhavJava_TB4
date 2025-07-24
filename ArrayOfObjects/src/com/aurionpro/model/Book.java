package com.aurionpro.model;

public class Book {

	int bookID;
	String title;
	
	public Book (int bookID , String title) {
		
		this.bookID=bookID;
		this.title=title;}
	
	public void display() {
		
		System.out.println("BookID: "+ bookID +" "+  "Title "+ title );
		
		
		
	}
} 
