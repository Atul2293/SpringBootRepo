package com.example.StudentBootDemo.course;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.example.StudentBootDemo.student.StudentModel;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "course")
public class CourseModel {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long cid;
	
	
	private String name;
	
	
	private String decription;
	
	
	 @ManyToOne(fetch = FetchType.EAGER)
	 @JoinColumn(name = "student_id")
	 private StudentModel student ;
	

	
	
	public CourseModel() {
		// TODO Auto-generated constructor stub
	}

	
	
	@JsonIgnore
	public StudentModel getStudent() {
		return student;
	}




	public void setStudent(StudentModel student) {
		this.student = student;
	}




	public CourseModel(@NotNull String name, @NotNull String decription) 
	{
		super();
		this.name = name;
		this.decription = decription;
		
	}

	public Long getCid() {
		return cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDecription() {
		return decription;
	}

	public void setDecription(String decription) {
		this.decription = decription;
	}
	
	
	
	

}
