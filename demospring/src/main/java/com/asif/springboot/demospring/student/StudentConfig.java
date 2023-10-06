package com.asif.springboot.demospring.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.asif.springboot.demospring.repo.StudentRepository;

@Configuration
public class StudentConfig {

	ArrayList<Student> students = new ArrayList<Student>();
	
	@Bean
	CommandLineRunner commandLineRunner(
			StudentRepository repository) {
		return args -> {
			
			students.add(new Student(
					"Mariam",
					"mariam.jamal@gmail.com",
					LocalDate.of(2000, Month.JANUARY,5)
					));
			
			students.add(new Student(
					"Alex",
					"alex.jamal@gmail.com",
					LocalDate.of(2004, Month.JANUARY,5)
					));
			
			repository.saveAll(students);
		};
		
	}
}
