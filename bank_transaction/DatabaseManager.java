package com.aurionpro.jdbc.bank_transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
	private static final String URL = "jdbc:mysql://localhost:3306/bank_transaction";
	private static final String USER = "root";
	private static final String PASSWORD = "root123";

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}

}
