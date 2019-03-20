package com.msbhosale.test;

import com.msbhosale.dao.StudentDAO;

public class TestJDBC {

	public static void main(String[] args) {
		
		StudentDAO sd = new StudentDAO();
		
		String studentName = sd.getStudentName(1);
		
		System.out.println(studentName);
	}
}