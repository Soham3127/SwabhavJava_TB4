package com.aurionpro.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.mysql.cj.xdevapi.Statement;

public class JdbcCRUD {
	public static void main(String[] args) throws Exception {

		// Register Driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Create Connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo", "root", "root123");
		System.out.println("Connected to DB successfully");

		// Insert Operation

		String insertQuery = "insert into students(roll_no , name ) values (?,?)";

		PreparedStatement ps = connection.prepareStatement(insertQuery);
		ps.setString(1, "45");
		ps.setString(2, "Soham");
		ps.execute();

		ps.setString(1, "46");
		ps.setString(2, "ABC");
		int rows = ps.executeUpdate();

		ps.setInt(1, 47);
		ps.setString(2, "Rohan");
		rows += ps.executeUpdate();
		System.out.println(rows + " Row added successfully");

		String selectQuery = "select * from students";
		PreparedStatement up = connection.prepareStatement(selectQuery);
		ResultSet rs = up.executeQuery(selectQuery);

		System.out.println("Fetching records...");

		while (rs.next()) {
			System.out.println(rs.getInt("roll_no") + " - " + rs.getString("name"));

			// Update Operation

			String updateQuery = "update students set name = ? where roll_no = ?";
			PreparedStatement ps2 = connection.prepareStatement(updateQuery);
			ps2.setString(1, "Jagtap");
			ps2.setInt(2, 54);
			int updatedRows = ps2.executeUpdate();
			System.out.println(updatedRows + " Row(s) updated");

			// Delete Operation

			String deleteQuery = "DELETE FROM students WHERE roll no =?";
			PreparedStatement ps3 = connection.prepareStatement(deleteQuery);
			ps3.setInt(1, 47);
			int rowsDeleted = ps.executeUpdate();
			System.out.println(rowsDeleted + " Rows deleted ");

			connection.close();
		}

	}
}