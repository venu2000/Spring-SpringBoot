package com.Controller;

import java.io.IOException;
import java.sql.SQLException;

import com.DAO.AdminDAO;
import com.model.Admin;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")      
public class LoginServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
	
		
		
		Admin admin = new Admin(username,password);
		AdminDAO adminDAO = new AdminDAO();
	
			boolean isValid = adminDAO.validateAdmin(admin);
			if(isValid) {
				
				HttpSession session = req.getSession();
				String[] split = username.split("@");
				session.setAttribute("username", split[0]);     // to print username in employee.jsp through session scope
				
				/*
				 * RequestDispatcher requestDispatcher =
				 * req.getRequestDispatcher("employees.jsp"); requestDispatcher.forward(req,
				 * resp);
				 */
				
				resp.sendRedirect("employees");   
				//sendRedirect 1st sends Login Status to Employee servlet
				//along with this it will print Employee details 
				
				
			}else {
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.html");
				requestDispatcher.forward(req, resp);
			}
		
		

		
		
		
		
	
	}

}
