package com.sandeep.bank.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/bank";
	private static final String username="root";
	private static final String password="root";
	
	
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(DB_URL, username, password);
			System.out.println("connected");
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}


	
	
	
}
