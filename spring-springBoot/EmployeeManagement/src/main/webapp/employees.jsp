<%@page import="java.util.*,com.model.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Dashboard</title>


</head>
<body>

<marquee>
    HI ! Welcome 
    <%= session.getAttribute("username") %>
    to Employee Dashboard!!!
</marquee>

<br><br>

<a href="addEmployee.jsp">Add Employees</a>

<h1>Employees Dashboard</h1>

<table border="1">

    <tr>
        <th>Employee ID</th>
        <th>Employee Name</th>
        <th>Employee Email</th>
        <th>Employee Phone Number</th>
        <th>Employee Salary</th>
        <th>Employee Status</th>
         <th>Employee Actions</th>
    </tr>

<%
    List<Employee> employeeList = 
        (List<Employee>) request.getAttribute("empList");

 
        for(Employee emp : employeeList){
%>

    <tr>
        <td><%= emp.getEmpid() %></td>
        <td><%= emp.getEmpName() %></td>
        <td><%= emp.getEmpEmail() %></td>
        <td><%= emp.getPhoneNumber() %></td>
        <td><%= emp.getSalary() %></td>
        <td><%= emp.isActive() %></td>
          <td>
            <a href="updateEmployees?id=<%= emp.getEmpid() %>">
                UpdateEmployee
            </a> 
            | 
            <a href="delete?id=<%= emp.getEmpid() %>">
                DeleteEmployee
            </a>
        </td>
    </tr>



    

<%
    }
%>

</table>

</body>
</html>