package com.solidprinciples.DIP.database;

public class DatabaseMain {
	public static void main(String[] args) {
		
		//Dependency Injection
		IDatabase database;
		
		public DatabaseMain(IDatabase data) {
			
			this.database= data;
		}
		
		
		
	}

}
