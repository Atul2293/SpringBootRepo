package com.example.StudentBootDemo.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.StudentBootDemo.course.CourseModel;
import com.example.StudentBootDemo.course.CourseRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository repo;
	
	@Autowired
	CourseRepository crepo;
	
	public List<StudentModel> getAllStudents() 
	{
		
		return repo.findAll();
	}
	
	
	public StudentModel createNewStudent(StudentModel student)
	{
		return repo.save(student);
	}
	
	
	public StudentModel getStudById(Long id) {
		
		return repo.findById(id).get();
		
	}
	
public StudentModel updateStudent(StudentModel newStud) {
		
		
		StudentModel updatedStud=repo.save(newStud);
		return updatedStud;
		
	}



public Integer deleteStudent(Long id) {
	
	List<CourseModel> courses=crepo.findByStudentId(id);
	for(int i=0;i<courses.size();i++)
	{
		crepo.delete(courses.get(i));
	}
	
	StudentModel stud = repo.findById(id).get();
    if(stud == null) {
        return 0;
    }

   
     repo.delete(stud);
    return 1;
}


}
