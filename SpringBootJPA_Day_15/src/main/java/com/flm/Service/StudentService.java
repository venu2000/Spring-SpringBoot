package com.flm.Service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.flm.model.Student;

public interface StudentService  {
	
	
	String saveStd();

    Student getStudent();

    List<Student> allStudents();

    Student delete(int id);

    Student updateStudent(int id);

    // JPQL Methods
    Student getStudentBasedOnId(int id);

    List<Student> getStudentBasedOnMarks(int marks);

    List<Student> getStudentByName(String name);

    List<Student> getStudentByNameStartWith(String name);

    // Pagination
    public Page<Student> findByPage(int page, int size);

    // Sorting
    public Page<Student> sortByMarks(int page, int size);
}


