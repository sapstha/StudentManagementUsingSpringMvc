package com.sapana.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;

import com.sapana.model.Student;

public class StudentExtractor {
	public Student extractData(ResultSet rs) throws SQLException,DataAccessException{
		Student student = new Student();
		student.setId(rs.getInt("ID"));
		student.setName(rs.getString("NAME"));
		student.setAddress(rs.getString("ADDRESS"));
		student.setEmail(rs.getString("EMAIL"));
		student.setContact(rs.getInt("CONTACT"));
		 
		 System.out.println(student.getName());	
		return student;

}
}