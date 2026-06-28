package com.flm.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flm.Repository.StudentRepository;
import com.flm.model.Student;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	public String saveStd() {
		Student std = new Student("Naveena", 90);
		studentRepository.save(std);
		return std.getName();
		
	}

}
