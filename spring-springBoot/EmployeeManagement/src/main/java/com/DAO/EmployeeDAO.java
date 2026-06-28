package com.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Employee;
import com.util.Constants;
import com.util.DbConnection;

public class EmployeeDAO {
	
	
	public List<Employee> getEmployees(){
		
		
		Connection connection = DbConnection.getConnection();
		
		List<Employee> empList = new ArrayList();
		try {
			PreparedStatement statement = connection.prepareStatement(Constants.SELECT_EMPLOYEES);
			
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				int empId = resultSet.getInt(1);
				String empName = resultSet.getString(2);
				String empEmail = resultSet.getString(3);
				String empPhoneNum = resultSet.getString(4);
				double empSalary = resultSet.getDouble(5);
				boolean isActive = resultSet.getBoolean(6);
				
				Employee emp = new Employee(empId, empName, empEmail, empPhoneNum, empSalary, isActive);
				empList.add(emp);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return empList;
		
	
		
	}
	
	
	
	public void  addEmployee(Employee employee) {
		Connection connection = DbConnection.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(Constants.ADD_EMPLOYEE);
			statement.setString(1, employee.getEmpName());
			statement.setString(2, employee.getEmpEmail());
			statement.setString(3, employee.getPhoneNumber());
			statement.setDouble(4, employee.getSalary());
			statement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	
	
	public void deleteEmployeeById(int empId) {
		
		try {
			Connection connection =DbConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(Constants.DELETE_EMPLOYEE);
			statement.setBoolean(1, false);
			statement.setInt(2, empId);
			statement.executeUpdate();
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	public Employee getEmployeeById(int empId) {
		
		Connection connection = DbConnection.getConnection();
		Employee emp = null;
		try {
			PreparedStatement statement = connection.prepareStatement(Constants.SELECT_EMPLOYEE_BY_ID);
			statement.setInt(1, empId);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				int id = resultSet.getInt(1);
				String empName = resultSet.getString(2);
				String empEmail = resultSet.getString(3);
				String empPhoneNum = resultSet.getString(4);
				double empSalary = resultSet.getDouble(5);
				boolean isActive = resultSet.getBoolean(6);
				
				 emp = new Employee(id, empName, empEmail, empPhoneNum, empSalary, isActive);
				
			}

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;

		
	}
	
	
	public void updateEmployee(Employee emp) {
		
		
		Connection connection = DbConnection.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(Constants.UPDATE_EMPLOYEE_BY_ID);
			statement.setString(1, emp.getEmpName());
			statement.setString(2, emp.getEmpEmail());
			statement.setString(3, emp.getPhoneNumber());
			statement.setDouble(4, emp.getSalary());
			statement.setInt(5, emp.getEmpid());
			
			statement.executeUpdate();
		
			
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	}
	
	

}
