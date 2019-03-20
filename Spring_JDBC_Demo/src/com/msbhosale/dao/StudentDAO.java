package com.msbhosale.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.msbhosale.setting.JdbcConnection;

public class StudentDAO {

	public String getStudentName(int rollNumber) {

		String studentName = null;

		String query = "SELECT name FROM student WHERE roll_number = ?";

		try {

			Class.forName("com.mysql.jdbc.Driver");

			Connection connection = JdbcConnection.getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(query);

			preparedStatement.setInt(1, rollNumber);
			
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				studentName = resultSet.getString(1);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return studentName;
	}
}