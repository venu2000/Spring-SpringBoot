package com.flm.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.flm.Repository.StudentRepository;
import com.flm.Service.StudentService;
import com.flm.model.Student;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	public String saveStd() {
		Student std = new Student("Naveena Gopal",99);
		studentRepository.save(std);
		return std.getName();
		
	}

	public Student getStudent() {
		Optional<Student> studentOptional = studentRepository.findById(6);
		Student student = studentOptional.get();
		return student;
	}
	
	
	public List<Student> allStudents(){
		
		List<Student> allstudents = studentRepository.findAll();
		return allstudents;
		
	}
	
	
	
	public Student delete(int id) {
		
		Student student = studentRepository.findById(id).get();
		studentRepository.delete(student);
		return student;
		
	}
	
	
	public Student updateStudent(int id) {
		Optional<Student> studentOptional = studentRepository.findById(id);
		Student student = studentOptional.get();
		student.setName("Aruna Kumari");
		return studentRepository.save(student);
	}
	
	/*
	 * // JPQL STARTS HERE
	 */	

	
	public Student getStudentBasedOnId(int id) {
		Student studentById = studentRepository.getStudentById(id);
		return studentById;
	}
	
	
	public List<Student> getStudentBasedOnMarks(int marks){
		List<Student> students = studentRepository.getStudentsBasedOnMarks(marks);
	    return students;
	}
	
	
	public List<Student> getStudentByName(String name) {
		List<Student> student = studentRepository.findByName(name);
		return student;
	}
	
	public List<Student> getStudentByNameStartWith(String name) {
		List<Student> student = studentRepository.findByNameStartsWith(name);
		return student;
	}
	
	
	/*
	 *  Pagination 
	 *  
	 *  */
	
	
	public Page<Student> findByPage(int page, int size){
		
		PageRequest pageRequest = PageRequest.of(page, size);
		Page<Student> allStudents = studentRepository.findAll(pageRequest);
		
		
		return allStudents;
		
		
	}
	
	
	/*
	 *  Sorting 
	 *  
	 *  */
	public Page<Student> sortByMarks(int page, int size){
		
		Sort ascending = Sort.by("marks").ascending();
		
		PageRequest pageRequest = PageRequest.of(page, size,ascending);
		Page<Student> allstudents = studentRepository.findAll(pageRequest);
		return allstudents;
		
	}
	
}
