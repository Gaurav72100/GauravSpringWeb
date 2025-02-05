<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Employee Form</title>
</head>
<body>
	<h2>Employee Form</h2>
	
	<form action="${employee.id == 0 ? 'addEmployee' : 'updateEmployee'}"
		method="post">
		
		 <input type="hidden" name="id" value="${employee.id}"/>
		<label  for="name">Name:</label> <input type="text" id="name" value="${employee.name }"
			    name="name" /><br />
		<br /> 
		
		 <label for="password">Password:</label> <input type="text" value="${employee.password }"
			    id="password" name="password" /><br />
		<br /> 
		
		 <label for="email">Email:</label> <input type="email" id="email" value="${employee.email }"
			     name="email" />
			   
			     <br /><br />

		<button type="submit">Submit</button> <br/>
		 
	</form>
</body>
</html>