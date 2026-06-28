package com.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Students {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "std_id")
	private int studentId;
	
	@Column(name = "std_name")
	private String studentname;
	

	private int marks;

	
	
	
	

	public Students() {
		super();
	}


	public int getStudentId() {
		return studentId;
	}


	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}


	public String getStudentname() {
		return studentname;
	}


	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}


	public int getMarks() {
		return marks;
	}


	public void setMarks(int marks) {
		this.marks = marks;
	}


	@Override
	public int hashCode() {
		return Objects.hash(marks, studentId, studentname);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Students other = (Students) obj;
		return marks == other.marks && studentId == other.studentId && Objects.equals(studentname, other.studentname);
	}


	public Students(int studentId, String studentname, int marks) {
		super();
		this.studentId = studentId;
		this.studentname = studentname;
		this.marks = marks;
	}


	public Students(String studentname, int marks) {
		super();
		this.studentname = studentname;
		this.marks = marks;
	}


	@Override
	public String toString() {
		return "Students [studentId=" + studentId + ", studentname=" + studentname + ", marks=" + marks + "]";
	}
	

	
	
	
	
	
	
	
}
