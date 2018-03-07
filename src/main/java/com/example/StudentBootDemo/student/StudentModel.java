package com.example.StudentBootDemo.student;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.example.StudentBootDemo.course.CourseModel;

@Entity
@Table(name = "student")
@EntityListeners(AuditingEntityListener.class)
public class StudentModel  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank
	@Column(nullable = false, updatable = false)
	private String name;
	
	@Column(nullable = false, updatable = false)
	private String standard;
	
	 @OneToMany(mappedBy = "student",  fetch = FetchType.EAGER)
	private Set<CourseModel> courses = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public StudentModel() {
		// TODO Auto-generated constructor stub
	}
	
	public StudentModel(Long id, String name, String standard) {
		super();
		this.id=id;
		this.name = name;
		this.standard = standard;
		
	}

	public Set<CourseModel> getCourses() {
		return courses;
	}

	public void setCourses(Set<CourseModel> courses) {
		this.courses = courses;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}
	
	
	

}
