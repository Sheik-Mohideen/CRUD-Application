package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentService
{
	@Autowired
	StudentsRepo repo;
	public 	List<StudentsData> getStudents()
	{	
		return repo.findAll();
	}
	
	public StudentsData getStudent(Integer id)
	{	
		Optional<StudentsData> employee = repo.findById(id);
		if(employee.isPresent()) {
			
            return employee.get();
        } else {
            throw new StudentNotFoundException(id);
        }
	}
	
	public StudentsData addStudent(StudentsData dt)
	{	
		StudentsData data=repo.save(dt);
		return data;
		
	}
	
	public StudentsData saveOrUpdateStudent(Integer id,StudentsData dt)
	{	
		
		if(repo.existsById(id))
		{	
			StudentsData temp=repo.getOne(id);
			temp.setName(dt.getName());
			temp.setDept(dt.getDept());
			return repo.save(temp);
		}
		else
		{	
			dt.setId(id);
			return repo.save(dt);
		}
		
	}
	
	public void deleteStudent(Integer id)
	{
		if(repo.existsById(id))
		{
			repo.deleteById(id);
		}
		else
		{
			throw new StudentNotFoundException(id);
		}
	}
}
