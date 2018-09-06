<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="lavender">
	<h1>Add new employee</h1>
	<hr>
	<form action="addEmployee" method="post">
	
	
	<label>Employee ID:</label>
	<input type="number" name="empId" required/>
	<br>
	
	
	<label>Employee Name:</label>
	<input type="text" name="empName" required/>
	<br>
	
	
	
	
	<label>Employee Salary:</label>
	<input type="number" name="empSalary" required/>
	<br>
	
	
	<label>Employee Dept:</label>
	<select  name="empDepartment" required>
	
		<option value="IT">IT</option>
		<option value="HR">HR</option>
		<option value="Admin">Admin</option>
		<option value="System">System</option>
	
	</select>
	<br>
	
	<input type="submit" value="SUBMIT">
	
	</form>
</body>
</html>