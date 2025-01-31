<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Employee Form</title>
</head>
<body>
	<h2>Employee Form</h2>
	
	<form action="${employee.id == null ? 'addEmployee' : 'updateEmployee'}"
		method="post">
		
		 <input type="hidden" name="id" value="${employee.id}"/>
		<label  for="name">Name:</label> <input type="text" id="name" value="${employee.name }"
			    name="name" /><br />
		<br /> 
		
		 <label for="department">Department:</label> <input type="text" value="${employee.department }"
			    id="department" name="department" /><br />
		<br /> 
		
		 <label for="salary">Salary:</label> <input type="number" id="salary" value="${employee.salary }"
			     name="salary" />
			   
			     <br /><br />

		<button type="submit">Submit</button> <br/>
		 
	</form>
</body>
</html>