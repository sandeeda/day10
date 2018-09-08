<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Employee Details</title>
<style type="text/css">
html, body {
	height: 100%;
}

body {
	margin: 0;
	background: linear-gradient(45deg, #49a09d, #5f2c82);
	font-family: sans-serif;
	font-weight: 100;
}

.container {
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
}

table {
	width: 100%;
	border-collapse: collapse;
	overflow: hidden;
	box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
}

th, td {
	padding: 15px;
	background-color: rgba(255, 255, 255, 0.2);
	color: #fff;
}

th {
	text-align: left;
}

thead {th { background-color:#55608f;
	
}

}
tbody {tr { &:hover {
			background-color : rgba(255, 255, 255, 0.3);
	
}

}
td {
	position: relative; &: hover { & : before { 
				 content : "";
	position: absolute;
	left: 0;
	right: 0;
	top: -9999px;
	bottom: -9999px;
	background-color: rgba(255, 255, 255, 0.2);
	z-index: -1;
}
}
}
}
</style>
</head>
<body>
	<h1 style="text-align:center; color:white;">Employee Details</h1>
	<div id="container">
		<hr>
		<br>
		<table border="1">
			<tr>
				<th>Employee Id</th>
				<th>Employee Name</th>
				<th>Employee Salary</th>
				<th>Employee Department</th>
				<th>Delete Employee</th>
				<th>Update Employee</th>
				
			</tr>
			<tbody>
			<c:forEach var="employee" items="${requestScope.employeesList}">
				<tr>
					<td>${employee.employeeId}</td>
					<td>${employee.employeeName}</td>
					<td>${employee.employeeSalary}</td>
					<td>${employee.employeeDepartment}</td>
					<td><a style="color: orange" href="delete?id=${employee.employeeId}">DELETE</a></td>
					<td><a style="color: yellow" href="update?id=${employee.employeeId}">UPDATE</a></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		<br>
		<a href="addEmployee.jsp"><button type="button">Add another Employee</button></a>
	</div>
</body>
</html>