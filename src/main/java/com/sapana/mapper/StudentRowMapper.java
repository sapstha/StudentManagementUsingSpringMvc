package com.sapana.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sapana.mapper.StudentExtractor;
import com.sapana.model.Student;

public class StudentRowMapper implements RowMapper<Student> {
	

	public Student mapRow(ResultSet resultSet, int line) throws SQLException {
		StudentExtractor studentExtractor= new StudentExtractor();
		return studentExtractor.extractData(resultSet);
	}
}