package com.sapana.exceptionhandler;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ControllerAdvice
@EnableWebMvc
public class ExceptionController{
	
	private Log logger = LogFactory.getLog(ExceptionController.class);

	@ExceptionHandler(value = SQLException.class)
	public @ResponseBody String SQLhandleError(@RequestBody Exception exception) {
		
		return "error";
	}
	
	

@ExceptionHandler(value = Exception.class)
public  String handleError(HttpServletRequest req, Exception exception) {
	logger.error("Request: " + req.getRequestURL() + " raised " + exception);
	return "error";
}
@ExceptionHandler(value = RuntimeException.class)
public  String handleExrror(HttpServletRequest req, Exception exception) {
	logger.error("Request: " + req.getRequestURL() + " raised " + exception);
	return "error";
}

@ResponseStatus(value=HttpStatus.CONFLICT,reason="Data integrity violation")  // 409
@ExceptionHandler(DataIntegrityViolationException.class)
public void conflict() {
// Nothing to do
}
}