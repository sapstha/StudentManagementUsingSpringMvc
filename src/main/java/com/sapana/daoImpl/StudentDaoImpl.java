package com.sapana.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sapana.dao.StudentDao;
import com.sapana.exceptionhandler.MyException;
import com.sapana.mapper.StudentExtractor;
import com.sapana.mapper.StudentRowMapper;
import com.sapana.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao {
	@Autowired
	DataSource dataSource;
	
	
	@Override
	public List<Student> listAllStudents() {
		try {
		String sql = "select * from studentdb";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List studentList = jdbcTemplate.query(sql, new StudentRowMapper());
		 System.out.println("List of Students="+studentList);
		return studentList;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new RuntimeException("Dummy Data");
		}
	}
	
	

	@Override
	public String saveStudent(Student student)  {
		try {		
			String sql = "INSERT INTO studentdb(name, address,  email, contact)  VALUES('"+student.getName()+"','"+student.getAddress()+"','"+student.getEmail()+"','"+student.getContact()+"')";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		  jdbcTemplate.update(sql);
		  return "ok";
		}catch(Exception e) {
			String s= e.getClass().getSimpleName();
			Throwable s1=e.getCause();
			String s2= e.getMessage();
			if(s.equalsIgnoreCase("DuplicateKeyException")) {
					
			System.out.println("myerror="+s+" Cause= "+s1);
			return s+"\n CAUSE:"+s1;
			}else
			{
				return e.getClass().getSimpleName();
			}
			
			
		}
		
		
		
		
	}

	@Override
	public Student updateStudent(Student student) {
		String sql="update studentdb set name=?,address=?,email=? ,contact=? where id=?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql,new Object[]{student.getName(),student.getAddress(),student.getEmail(),student.getContact(),student.getId()});
		int id=student.getId();
		System.out.println("id no="+id);
		return getStudentById(id);
	}

	@Override
	public Student getStudentById(int id) {
		 System.out.println("id from getStudentByID="+id);
		String sql="select * from studentdb where id=?"; 
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Student>(Student.class));  
	}

	@Override
	public int deleteStudentByID(int id) {
		String sql=" delete from studentdb where id="+id;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate.update(sql);
	
		 }
	
	
	

	

	/*
		String sql2="set @autoid :=0; update studentdb set id = @autoid := (@autoid+1);
				alter table studentdb Auto_Increment = 1;
		JdbcTemplate jdbcTemplate =new JdbcTemplate(dataSource);
		return jdbcTemplate.update(sql2);
		 
	}*/
	


}


