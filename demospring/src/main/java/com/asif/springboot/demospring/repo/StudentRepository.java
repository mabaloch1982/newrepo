package com.asif.springboot.demospring.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asif.springboot.demospring.student.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	
	Optional<Student> findByEmail(String email);

}
