package com.sapana.controller;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.sapana.model.Student;
import com.sapana.service.StudentService;
import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;

@Controller
public class StudentController {

	@Autowired
	StudentService studentService;

	@Autowired
	private DataSource dataSource;

	
	@RequestMapping("StudentList")
	public ModelAndView checkConnection()  {

		try {
			if (dataSource.getConnection() != null) {

				return new ModelAndView("StudentList", "msg", "Database Connection Successfully Established.");

			} else {

				return new ModelAndView("error", "msg", "Failed to connect database.");
			}
		} catch (SQLException e) {
			e.printStackTrace();

			return new ModelAndView("error", "msg", "Failed to connect database.");
		}
		
	}

	@RequestMapping(value = "/JSONData", method = RequestMethod.GET)
	@ResponseBody
	public List<Student> getJsonData() {
		return studentService.listAllStudents();
	}

	// to view students
	@RequestMapping(value = "/DataTableStudentList", method = RequestMethod.GET)
	@ResponseBody
	public List<Student> list() {

		return studentService.listAllStudents();
	}
	
	/*
	 * @RequestMapping(value="/save",method = RequestMethod.POST)
	 * public @ResponseBody int saveStudent(@RequestBody Student student) throws
	 * SQLException { // A request body is data sent by the client to // your API. A
	 * response body is the data
	 * 
	 * int result= studentService.saveStudent(student); if(result==1) { return
	 * result; } else { throw new SQLException("Database exception!!!"); }
	 * 
	 * 
	 * 
	 * // return "success";
	 * 
	 * }
	 */
	

	@RequestMapping(value="/save",method = RequestMethod.POST)
	public @ResponseBody String saveStudent(@RequestBody Student student) throws Exception{ // A request body is data sent by the client to
																			// your API. A response body is the data
		String s1= studentService.saveStudent(student);
		System.out.println("controller message="+s1);
		return s1;
	}
	

	/*
	 * @RequestMapping(value="/save", method=RequestMethod.POST) public int
	 * processRegisterUser(@RequestBody Student student){ int
	 * status=studentService.isStudentnameExist(student.getName());
	 * //System.out.println("status="+status);
	 * 
	 * if(status==1) { System.out.println("status="+status); return status; }
	 * 
	 * int result= studentService.saveStudent(student);
	 * System.out.println("result after save="+result);
	 * 
	 * 
	 * return result;
	 * 
	 * int result= studentService.saveStudent(student); return result; }
	 */

	@RequestMapping(value = "/editStudent/{id}")
	public @ResponseBody Student studentListById(@PathVariable("id") int id) {
		System.out.println("id" + id);
		Student s = studentService.getStudentById(id);
		System.out.println("getstudentintofrom::" + s);
		return s;
	}

	@RequestMapping(value = "/updateStudent", method = RequestMethod.POST)
	public @ResponseBody Student updateStudent(@RequestBody Student student) {
		System.out.println("TO update value=" + student.getName() + "\n" + student.getAddress() + "\n"
				+ student.getEmail() + " where id =" + student.getId());
		Student s = studentService.updateStudent(student);
		System.out.println("updated student=" + s);
		return s;
	}

	@RequestMapping(value = "/deleteStudentByID/{delID}", method = RequestMethod.POST)
	public @ResponseBody int deleteStudentById(@PathVariable("delID") int delID) {
		return studentService.deleteStudentByID(delID);
	}

	@ExceptionHandler(value=SQLException.class)
	public String ExceptionHandler(Exception e) {
		e.printStackTrace();
		String s=e.getMessage();
		System.out.print(s);
		return "ExceptionHandlingPage";
	}

	
}
