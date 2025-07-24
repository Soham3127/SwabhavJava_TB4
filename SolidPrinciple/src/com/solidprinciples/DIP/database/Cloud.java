package com.solidprinciples.DIP.database;

public class Cloud  implements IDatabase{

	@Override
	public void connect() {
	System.out.println("My Cloud connected...");
		
	}

}
