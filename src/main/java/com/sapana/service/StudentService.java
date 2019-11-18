package com.sapana.service;

import java.sql.SQLException;
import java.util.List;

import com.sapana.model.Student;

public interface StudentService {
	
	List<Student> listAllStudents();
	public String saveStudent(Student student) throws SQLException;
	public Student updateStudent(Student student);
	public Student getStudentById(int id);
	public int deleteStudentByID(int id);
	

}
