package com;



import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.config.Config;
import com.dao.StudentDAO;
import com.model.Students;

public class Application {

	public static void main(String[] args) {
		
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		StudentDAO studentDao = ctx.getBean("studentDAO", StudentDAO.class);
	//	Students students = studentDao.getStudents(1);
	//	System.out.println(students);
		
		studentDao.saveStudents(new Students( " Venu", 99)  );

	}

}
