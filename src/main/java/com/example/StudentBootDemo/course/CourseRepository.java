package com.example.StudentBootDemo.course;

import java.util.List;

import org.hibernate.sql.Delete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<CourseModel, Long> {

	public List<CourseModel> findByStudentId(Long sid);
	
	
}
