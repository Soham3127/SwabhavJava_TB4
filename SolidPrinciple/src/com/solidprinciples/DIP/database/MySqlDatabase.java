package com.solidprinciples.DIP.database;

public class MySqlDatabase  implements IDatabase{

	@Override
	public void connect() {
		System.out.println("MySQL is  connected......");
		
	}

}
