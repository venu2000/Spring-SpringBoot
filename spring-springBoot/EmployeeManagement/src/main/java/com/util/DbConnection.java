package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	
	public static Connection connection;
	
	public static Connection getConnection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
				if(connection==null) {
					Connection connection = DriverManager.getConnection(Constants.URL,Constants.USERNAME,Constants.PASSWORD);
			        return connection;
				}else {
					return connection;
				}
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		
		return null;
	}
	
	

	  

}
