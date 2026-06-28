<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Employee</title>
</head>
<body>

<form action="addEmployees" method = "post"  >
<label for="name">Name: </label>
<input type = "text" name="name" placeholder="Enter name"><br><br>
<label for="email">Email: </label>
<input type = "email" name="email" placeholder="Enter Email"><br><br>
<label for="phoneNum">Phone Number: </label>
<input type = "text" name="phoneNum" placeholder="Enter PhoneNumber"><br><br>
<label for="salary">Salary: </label>
<input type = "number" name="salary" placeholder="Enter Salary"><br><br>


<input type = "submit" value="Add Employee">
</form>

</body>
</html>