package com.sapana.exceptionhandler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

public class MyException extends Exception {
	
	public  String SQLhandleError(String e) {
		System.out.println("hello from SQLHandler where error message"+e);
		return "error";
	}

}
