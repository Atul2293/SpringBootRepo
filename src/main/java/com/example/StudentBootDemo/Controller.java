package com.example.StudentBootDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.StudentBootDemo.course.CourseModel;
import com.example.StudentBootDemo.course.CourseRepository;
import com.example.StudentBootDemo.student.StudentModel;
import com.example.StudentBootDemo.student.StudentRepository;

@RestController
public class Controller {

	
	@Autowired
	private StudentRepository studRep;
	
	@Autowired
	private CourseRepository courseRep;
	
	
	public void addStudent(@RequestBody StudentModel student,@RequestBody CourseModel course)
	{
		
	}
}
