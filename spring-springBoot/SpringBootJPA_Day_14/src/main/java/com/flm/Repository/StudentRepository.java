package com.flm.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flm.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
	

}
