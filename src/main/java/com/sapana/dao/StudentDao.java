package com.sapana.dao;

import java.util.List;

import com.sapana.model.Student;

public interface StudentDao {
	
	public List<Student> listAllStudents();
	public String saveStudent(Student student);
	public Student getStudentById(int id);
	public Student updateStudent(Student student);
	public int deleteStudentByID(int id);
   
	

}
