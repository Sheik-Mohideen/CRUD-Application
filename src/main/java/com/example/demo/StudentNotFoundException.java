package com.example.demo;

class StudentNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	StudentNotFoundException()
	{
		super();
	}
	StudentNotFoundException(Integer id)
	{
		super("The student id: "+id+" not found");
	}
}
