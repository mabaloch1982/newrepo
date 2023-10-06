package com.asif.springboot.demospring.service;

import java.awt.IllegalComponentStateException;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asif.springboot.demospring.repo.StudentRepository;
import com.asif.springboot.demospring.student.Student;

import jakarta.transaction.Transactional;

@Service
public class StudentService {

	private final StudentRepository studentRepository;
	
	 @Autowired
	   public StudentService(StudentRepository studentRepository) {
			this.studentRepository = studentRepository;
		}
	 
	/**
	 * @return
	 */
	public List<Student> getStudents() {

		
		 
		return studentRepository.findAll();
				
				/*
				List.of(
				new Student(
						1L,
						"Mariam",
						"mariam.jamal@gmail.com",
						LocalDate.of(2000, Month.JANUARY,5),
						21
						)
				);*/
		
	}

	public void addNewStudent(Student student) {

		Optional<Student> studentByEmail  =  studentRepository
				.findByEmail(student.getEmail());
		
		if(studentByEmail.isPresent())
			throw new IllegalComponentStateException("Email is already taken");

		studentRepository.save(student);
		System.out.println(student);
		// TODO Auto-generated method stub
		
	}

	public void deleteStudent(Long studentId) {
		// TODO Auto-generated method stub
		boolean exists = studentRepository.existsById(studentId);
		if(!exists) {
			throw new IllegalStateException(
					"Student with Id: " + studentId + " does not exist"
					);
		}
		studentRepository.deleteById(studentId);
		
		
	}

	@Transactional
	public void updateStudent(Long studentId, String name, String email) {
		// TODO Auto-generated method stub
		
		Student student = studentRepository.findById(studentId)
				.orElseThrow(() -> new IllegalStateException("Student with Id: " + studentId + " does not exist"));
				
		student.setName(name);
		student.setEmail(email);
	}

	
}
