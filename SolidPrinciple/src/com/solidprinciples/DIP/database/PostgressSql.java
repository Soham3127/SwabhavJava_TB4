package com.solidprinciples.DIP.database;

public class PostgressSql  implements IDatabase{

	@Override
	public void connect() {
		System.out.println(" PostgressSql connected ....");
		
	}

}
