package com.flm.Controller;

import com.flm.Repository.StudentRepository;
import com.flm.Service.StudentService;
import com.flm.ServiceImpl.StudentServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flm.model.Student;

@RestController
public class StudentController {
	
	
	@Autowired
	StudentService studentService;

	
	
	@GetMapping("/save")
	public String save() {
		
		String name = studentService.saveStd();
		return name;
		
	}
	
	@GetMapping("/studentById")
	public Student getStudentById() {
		 
		return studentService.getStudent();
	
	}

	@GetMapping("/allstudents")
	public List<Student> getAllStudents(){
		
		return studentService.allStudents();
		
	}
	
	@GetMapping("/delete")
	public Student deleteStudent(@RequestParam(name="id") int id) {
		
		return studentService.delete(id);
		
		
	}
	@GetMapping("/updateStudent")
	public Student updateStudent() {
		return studentService.updateStudent(1);
	}
	
	
	/* JPQL STARTS HERE */
	//http://localhost:8080/byId
	
//	@GetMapping("/byId")
//	public Student getStudentBasedOnId() {
//		return studentService.getStudentBasedOnId(9);
//		
//	}
	
// this is for Dynamic value( we use @RequestParam) which id is given from URL in Postman
	//http://localhost:8080/byId?id=7
	
	@GetMapping("/byId")
	public Student getStudentBasedOnId(@RequestParam(name="id") int id) {
		return studentService.getStudentBasedOnId(id);
		
	}
	
	@GetMapping("/byMarks")
	public List<Student> getStudentsBasedOnMarks(@RequestParam(name="marks")int marks){
		return studentService.getStudentBasedOnMarks(marks);
	}
	
	
	
	//http://localhost:8080/byMarks?marks=99
	@GetMapping("/byName")
	public List<Student> getStudentByName(@RequestParam(name="name") String name) {
		return studentService.getStudentByName(name);
	}
	
	
	//http://localhost:8080/byNameStartWith?name=Na
	@GetMapping("/byNameStartWith")
	public List<Student> getStudentByNameStartsWith(@RequestParam(name="name") String name) {
		return studentService.getStudentByNameStartWith(name);
	}
	
	/*
	 *  Pagination 
	 *  
	 *  */
	
	//http://localhost:8080/byPage?page=2&size=3
	@GetMapping("/byPage")
		public Page<Student> findByPage(@RequestParam(name = "page")int page, @RequestParam(name="size")int size){
		   return studentService.findByPage(page, size);
		   
	
		}
	
	
	/*
	 *  Sorting 
	 *  
	 *  */
	
	@GetMapping("/sortByMarks")
	public Page<Student> sortByMarks(@RequestParam(name ="page")int page, @RequestParam(name="size")int size){
		return studentService.sortByMarks(page, size);
		
	}
	
	
	}
	
	
	
	

