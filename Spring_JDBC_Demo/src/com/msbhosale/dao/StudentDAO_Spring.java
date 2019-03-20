package com.msbhosale.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.msbhosale.beans.Student;

@Repository(value = "student_dao")
public class StudentDAO_Spring {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public String getStudentName(int rollNumber) {

		String sql = "SELECT name FROM student WHERE roll_number = " + rollNumber;

		return jdbcTemplate.queryForObject(sql, String.class);
	}

	public Student getStudentByRollNumber(int rollNumber) {

		String sql = "SELECT * FROM student WHERE roll_number = ?";

		return jdbcTemplate.queryForObject(sql, new Object[] { rollNumber }, new StudentMapper());
	}

	public int saveStudent(Student student) {

		String sql = "INSERT INTO student VALUES (?,?)";

		return jdbcTemplate.update(sql, new Object[] { student.getRollNumber(), student.getName() });
	}

	public int updateStudent(Student student) {

		String sql = "UPDATE student SET name = ? WHERE roll_number = ?";

		return jdbcTemplate.update(sql, student.getName(), student.getRollNumber());
	}

	public List<Student> getAllStudents() {

		String sql = "SELECT * FROM student";

		return jdbcTemplate.query(sql, new StudentMapper());
	}

	private static final class StudentMapper implements RowMapper<Student> {

		@Override
		public Student mapRow(ResultSet resultSet, int row) throws SQLException {

			Student student = new Student();

			student.setRollNumber(resultSet.getInt("roll_number"));
			student.setName(resultSet.getString("name"));

			return student;
		}
	}
}