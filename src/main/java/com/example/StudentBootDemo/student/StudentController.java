package com.example.StudentBootDemo.student;

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

@RestController
@RequestMapping("/api")
public class StudentController {

	@Autowired
	StudentService service;

	// get all students
	@GetMapping("/students")
	public List<StudentModel> getAllNotes() {
		return service.getAllStudents();
	}

	// Create a new student(/api/students)
	@PostMapping("/students")
	public StudentModel createStud(@RequestBody StudentModel student) {
		return service.createNewStudent(student);
	}

	// Get a Single Student by its ID
	@GetMapping("/students/{id}")
	public ResponseEntity<StudentModel> getStudById(@PathVariable Long id) {
		
		StudentModel student =service.getStudById(id);
		
		if (student == null) {
			return	ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(student);
	}

	// Update Student

	@PutMapping("/students/{id}")
	public ResponseEntity<StudentModel> updateStudent(@PathVariable Long id,@RequestBody StudentModel newStud) {
		
		newStud.setId(id);
		StudentModel newStudent=service.updateStudent(newStud);
		if (newStudent == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(newStudent);
		
	
	}
	
	
	//Delete Student 
	@DeleteMapping("/students/{id}")
	public ResponseEntity<StudentModel> deleteStudent(@PathVariable Long id) {
		
		Integer deleteFlag=service.deleteStudent(id);
	    if(deleteFlag == 0) {
	        return ResponseEntity.notFound().build();
	    }
	    return ResponseEntity.ok().build();
	}

}
