package com.sapana.serviceImpl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapana.dao.StudentDao;
import com.sapana.model.Student;
import com.sapana.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentDao studentDao;

	@Override
	public List<Student> listAllStudents() {
		// TODO Auto-generated method stub
		return studentDao.listAllStudents();
	}

	@Override
	public String saveStudent(Student student) throws SQLException {
		// TODO Auto-generated method stub
		return studentDao.saveStudent(student);
	}

	@Override
	public Student updateStudent(Student student) {
		// TODO Auto-generated method stub
		return studentDao.updateStudent(student);
	}

	@Override
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		return studentDao.getStudentById(id);
	}

	@Override
	public int deleteStudentByID(int id) {
		// TODO Auto-generated method stub
		return studentDao.deleteStudentByID(id);
	}


}
