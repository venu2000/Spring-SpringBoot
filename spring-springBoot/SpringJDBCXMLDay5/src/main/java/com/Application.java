package com;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.entity.Emplopyees;

public class Application {

	public static void main(String[] args) {
		
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		JdbcTemplate template = ctx.getBean("template", JdbcTemplate.class);
		//template.update("INSERT into employees values(?,?,?)",11,"Venu A T","100000");
		//System.out.println("Data Inserted....");
//		template.update("UPDATE employees set salary = ? where empid = ? ", 200000,11);
//		System.out.println("Data Updated....");
		
//		template.update("DELETE from employees where empid = 2");
//		System.out.println("Data DELETED....");
		
		
		List<Emplopyees> list = template.query("SELECT * from employees", new RowMapper<Emplopyees>(){

			@Override
			public Emplopyees mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				return 	new Emplopyees(rs.getInt(1), rs.getString(2), rs.getInt(3));
			}
			
			
				
			
		});
		System.out.print(list);
		
		
		//with anonymous inner class 
		Emplopyees employees = template.queryForObject("SELECT * from employees where empid = 3", new RowMapper<Emplopyees>(){

			@Override
			public Emplopyees mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				return 	new Emplopyees(rs.getInt(1), rs.getString(2), rs.getInt(3));
			}
			
			
				
			
		});
		System.out.println();
		System.out.print(employees);
		
		// with LambDa Experssion
		Emplopyees employees2 = template.queryForObject("SELECT * from employees where empid = ?", 
 (rs , rowNum) -> new Emplopyees(rs.getInt(1), rs.getString(2), rs.getInt(3)),11);
		System.out.println("...");
		System.out.print(employees2);

	}

	}
	
	

	


