package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentsController {
	
	@Autowired
	StudentService service;
	@GetMapping("/student")
	public 	ResponseEntity<List<StudentsData>> getStudents()
	{	
		List<StudentsData> data=service.getStudents();
	return new ResponseEntity<List<StudentsData>>(data,HttpStatus.OK);
	}
	
	@GetMapping("/student/{id}")
	public ResponseEntity<StudentsData> getStudent(@PathVariable("id") Integer id)
	{	
		StudentsData data=service.getStudent(id);
		return new ResponseEntity<StudentsData>(data,HttpStatus.OK);
	}
	
	@PostMapping(path="/student",consumes="application/json")
	public ResponseEntity<StudentsData> addStudent(@RequestBody StudentsData dt)
	{
		StudentsData data=service.addStudent(dt);
		return new ResponseEntity<StudentsData>(data,HttpStatus.OK);
		
	}
	
	@PutMapping(path="/student/{id}",consumes="application/json")
	public ResponseEntity<StudentsData> saveOrUpdateStudent(@PathVariable("id") Integer id, @RequestBody StudentsData dt)
	{	
		StudentsData data=service.saveOrUpdateStudent(id,dt);
		return new ResponseEntity<StudentsData>(data,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/student/{id}")
	public HttpStatus deleteStudent(@PathVariable("id") int id)
	{
		service.deleteStudent(id);
		return HttpStatus.FORBIDDEN;
	}
}
