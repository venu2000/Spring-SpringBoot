package com.Controller;

import java.io.IOException;

import com.DAO.EmployeeDAO;
import com.model.Employee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addEmployees")
public class AddEmployeeServlet extends HttpServlet{
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String phoneNum = req.getParameter("phoneNum");
		double salary = Double.parseDouble(req.getParameter("salary"));
		
		Employee emp = new Employee(name, email, phoneNum, salary);
		
		EmployeeDAO empDao = new EmployeeDAO();
		empDao.addEmployee(emp);
		
		
		resp.sendRedirect("employees");   
		
		
		
		
		
	}
	
	
	

}
