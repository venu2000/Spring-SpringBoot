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

@WebServlet("/signup")       //signup is from action of signup.html
public class SignUpServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String confirmPassword = req.getParameter("confirmpassword");
		
		
		Admin admin = new Admin(username,password);
		AdminDAO adminDAO = new AdminDAO();
		try {
			adminDAO.saveAdmin(admin);
			System.out.println("Admin saved....");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.html");
		requestDispatcher.forward(req, resp);
		
		
		
		
	
	}

}
