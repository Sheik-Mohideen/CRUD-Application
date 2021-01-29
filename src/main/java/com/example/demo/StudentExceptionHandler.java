package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus(HttpStatus.NOT_FOUND)
@ResponseBody
class StudentExceptionHandler extends ResponseEntityExceptionHandler
{
	@ExceptionHandler(StudentNotFoundException.class)
	public List<String> handleStudentException(StudentNotFoundException ex)
	{
		List<String> dt= new ArrayList<>();
		dt.add(ex.getLocalizedMessage());
		return dt;
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleAllException(Exception ex)
	{	
		List<String> details= new ArrayList<>();
		for(ObjectError obj: ex.getBindingResult().getAllErrors() )
		{
			details.add(obj.getDefaultMessage());
		}
		StudentError error= new StudentError("Validation failed",details);
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
}