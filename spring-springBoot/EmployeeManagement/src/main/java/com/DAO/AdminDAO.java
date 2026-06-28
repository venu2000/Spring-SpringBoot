package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.Admin;
import com.util.Constants;
import com.util.DbConnection;

public class AdminDAO {
	
	
	
	
	public void saveAdmin(Admin admin) throws SQLException {
		
		Connection connection = DbConnection.getConnection();
		
		PreparedStatement statement = connection.prepareStatement(Constants.INSERT_ADMIN);
		statement.setString(1, admin.getUsername());
		statement.setString(2, admin.getPassword());
		
		statement.executeUpdate();
		
		
	}

	public boolean validateAdmin(Admin admin)  {

		Connection connection = DbConnection.getConnection();
		
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(Constants.SELECT_ADMIN);
			statement.setString(1, admin.getUsername());
			statement.setString(2, admin.getPassword());
			
			ResultSet resultSet = statement.executeQuery();
			System.out.println("LOGIN RESULT: " + resultSet.next());
			return resultSet.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}	
	  

}
