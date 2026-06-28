package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.model.Students;

import jakarta.transaction.Transactional;


@Component
@Transactional
public class StudentDAO {
	
	
	@Autowired
	SessionFactory sessionFactory;
	
	public Students getStudents(int id ) {
		
		Session session = getSession();
	    Students students = session.find(Students.class, id);
	    return students;
	  
	}
	
	public void  saveStudents(Students students) {
		Session session = getSession();
	    session.persist(students);
		
		
	}
	
	private Session getSession() {
		Session session = sessionFactory.getCurrentSession();
		return session;
	}

	

}
