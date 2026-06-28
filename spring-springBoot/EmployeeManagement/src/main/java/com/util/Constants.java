package com.util;

public class Constants {
	
	public static String URL = "jdbc:mysql://localhost:3306/webapp";
	public static String USERNAME = "root";
	public static String PASSWORD = "Venu@1526";
	

	
	public final static String INSERT_ADMIN = "insert into admin (username,password) values(?,?)";
          
	public final static String SELECT_ADMIN = "select * from admin where username = ? and password = ?";

	
	public final static String SELECT_EMPLOYEES = "select * from employees";
	
	public final static String ADD_EMPLOYEE = "insert into employees (name,email,phoneNum,salary) values(?,?,?,?)";
	
	
	public final static String DELETE_EMPLOYEE = "update employees set isActive =? where empId =?";
	
	public final static String SELECT_EMPLOYEE_BY_ID = "select * from employees where empId = ?";
	
	public final static String UPDATE_EMPLOYEE_BY_ID = "update employees set name =?, email=?, phoneNum=?,salary=? where empId = ? ";
	
	
	
}
