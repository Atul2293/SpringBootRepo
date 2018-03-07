package com.example.StudentBootDemo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;



@SpringBootApplication
@EnableJpaAuditing
public class StudentBootDemoApplication {

	
	
	public static void main(String[] args) {
		SpringApplication.run(StudentBootDemoApplication.class, args);
	}
	
	
	
}
