<%@ page language="java"  import="com.model.*"  contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%Employee emp = (Employee)request.getAttribute("emp"); %>

<form action="updateEmployees" method="post">

    <input type="hidden"
           name="empId"
           value="<%= emp.getEmpid() %>">

    <label for="name">Name:</label>
    <input type="text"
           name="name"
           placeholder="Enter name"
           value="<%= emp.getEmpName() %>">
    <br><br>

    <label for="email">Email:</label>
    <input type="email"
           name="email"
           placeholder="Enter Email"
           value="<%= emp.getEmpEmail() %>">
    <br><br>

    <label for="phoneNum">Phone Number:</label>
    <input type="text"
           name="phoneNum"
           placeholder="Enter PhoneNumber"
           value="<%= emp.getPhoneNumber() %>">
    <br><br>

    <label for="salary">Salary:</label>
    <input type="number"
           name="salary"
           placeholder="Enter Salary"
           value="<%= emp.getSalary() %>">
    <br><br>

    <label for="isActive">isActive:</label>
    <input type="text"
           name="isActive"
           placeholder="isActive"
           value="<%= emp.isActive() %>">
    <br><br>

    <input type="submit"
           value="Update Employee">

</form>

</body>
</html>