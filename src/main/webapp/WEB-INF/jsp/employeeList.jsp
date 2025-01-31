<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Submit Data Successfully</title>
</head>
<body>


<a href="show">New_User</a>
<br/>
  <table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Department</th>
        <th>Salary</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="employee" items="${employees}">
        <tr>
            <td>${employee.id}</td>
            <td>${employee.name}</td>
            <td>${employee.department}</td>
            <td>${employee.salary}</td>
            
            <td><a href="edit/${employee.id }">Edit_User</a><br/>
                 <a href="delEmployee/${employee.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>