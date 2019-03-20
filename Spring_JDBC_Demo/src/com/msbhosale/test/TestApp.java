package com.msbhosale.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.msbhosale.beans.Student;
import com.msbhosale.dao.StudentDAO_Spring;

public class TestApp {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

		StudentDAO_Spring sd = (StudentDAO_Spring) context.getBean("student_dao");

		int updatedStudent = sd.updateStudent(new Student(4, "Sachin Dhole"));

		System.out.println(updatedStudent + " record updated");

		System.out.println("Getting all students : ");

		List<Student> students = sd.getAllStudents();

		for (Student student : students) {

			System.out.println(student);
		}
	}
}