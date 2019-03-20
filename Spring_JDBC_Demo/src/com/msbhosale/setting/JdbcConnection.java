package com.msbhosale.setting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {

	private static final String URL = "jdbc:mysql://localhost:3306/spring";
	private static final String USER = "root";
	private static final String PASSWORD = "root";

	public static Connection getConnection() throws SQLException {

		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
}