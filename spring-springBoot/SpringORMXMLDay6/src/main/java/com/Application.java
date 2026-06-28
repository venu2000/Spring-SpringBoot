package com;



import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.StudentDAO;
import com.model.Students;

public class Application {

	public static void main(String[] args) {
		
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		StudentDAO studentDao = ctx.getBean("studentDAO", StudentDAO.class);
		Students students = studentDao.getStudents(1);
		System.out.println(students);
		
		List<Students> printAllStudents = studentDao.printAllStudents();
		System.out.println(printAllStudents);
	
	//	studentDao.saveStudents(new Students( " Venu", 99)  );

	}

}
