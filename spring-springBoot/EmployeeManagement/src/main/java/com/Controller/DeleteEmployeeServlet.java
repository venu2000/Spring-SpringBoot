package com.Controller;

import java.io.IOException;

import com.DAO.EmployeeDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DeleteEmployeeServlet extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int empId = Integer.parseInt(req.getParameter("id"));  //mentioned in deleteEmployee at employee.jsp
		
		EmployeeDAO empDAO = new EmployeeDAO();
		empDAO.deleteEmployeeById(empId);
		resp.sendRedirect("employees");      // redirects to employee and then employee.jsp will be displays the update
		
		
		
		
		
		
	}
	
	
	

}
