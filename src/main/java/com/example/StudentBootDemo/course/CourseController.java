package com.example.StudentBootDemo.course;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.StudentBootDemo.student.StudentModel;
import com.example.StudentBootDemo.student.StudentService;

@RestController
@RequestMapping("/api")
public class CourseController {

	@Autowired
	CourseService service;
	
	@Autowired
	StudentService studService;

	//get all courses 
	@GetMapping("/students/courses")
	public List<CourseModel> getAllCourse() 
	{
		return service.getAllCouses();	
	}
	
	
	// get all courses of particulat student id
	@GetMapping("/students/{stud_id}/courses")
	public List<CourseModel> getAllCourse(@PathVariable Long stud_id) {
		
		return service.getAllCousesOfStudent(stud_id);
		
	}

	// Create a new course with student id mapping
	@PostMapping("/students/{stud_id}/courses")
	public void createCourse(@PathVariable Long stud_id,@RequestBody CourseModel courses) {
		
		if(studService.getStudById(stud_id) != null)
		{
		courses.setStudent(new StudentModel(stud_id,"",""));
		service.createCourse(courses);
		}
		
	}
	
	// Get a Single course by it id
	@GetMapping("/students/{stud_id}/courses/{course_id}")
	public ResponseEntity<CourseModel> getCourseById(@PathVariable Long course_id) 
	{
		
		CourseModel course =service.getCourseById(course_id);
		
		if (course == null) {
			return	ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(course);
	}
	
	// Update course with its student id mapping


	@PutMapping("/students/{stud_id}/courses/{course_id}")
	public ResponseEntity<CourseModel> updateCourse(@PathVariable Long course_id,@PathVariable Long stud_id,@RequestBody CourseModel courses) {
		
		courses.setStudent(new StudentModel(stud_id,"",""));
		courses.setCid(course_id);
		CourseModel updatedStudent=service.updateCourse(courses);
		if (updatedStudent == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(updatedStudent);
		
	
	}
	
	//Delete course by its id
	@DeleteMapping("/students/{stud_id}/courses/{course_id}")
	public ResponseEntity<StudentModel> deleteCourse(@PathVariable Long course_id) 
	{
		
		Integer deleteFlag=service.deleteCourse(course_id);
	    if(deleteFlag == 0) {
	        return ResponseEntity.notFound().build();
	    }
	    return ResponseEntity.ok().build();
	}

}
