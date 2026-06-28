package com.Controller;

import java.io.IOException;

import com.DAO.EmployeeDAO;
import com.model.Employee;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/updateEmployees")
public class UpdateEmployeeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int empId = Integer.parseInt(req.getParameter("id"));
		EmployeeDAO empDAO = new EmployeeDAO();
		Employee employee = empDAO.getEmployeeById(empId);

		req.setAttribute("emp", employee);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("updateEmployees.jsp");
		requestDispatcher.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int empId = Integer.parseInt(req.getParameter("empId"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String phoneNum = req.getParameter("phoneNum");
		double salary = Double.parseDouble(req.getParameter("salary"));
		

		Employee emp = new Employee(empId, name, email, phoneNum, salary);

		EmployeeDAO empDAO = new EmployeeDAO();

		empDAO.updateEmployee(emp);

		resp.sendRedirect("employees");
	}

}
