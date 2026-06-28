package com.dao;

import java.util.List;

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
	public void  deleteStudents(Students students) {
		Session session = getSession();
	    session.remove(students);
		
		
	}
	
	
	public List<Students> printAllStudents() {

	    Session session = getSession();

	    List<Students> list = session.createQuery("from Students", Students.class)
	                                  .getResultList();

	    return list;
	}
	
	private Session getSession() {
		Session session = sessionFactory.getCurrentSession();
		return session;
	}

	

}
