<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student-List</title>
</head>
<body>
<h2>Student List</h2>
<table border="1" cellspacing="0" cellpadding="10">
<tr>
<th>ID</th><th>First Name</th><th>Last Name</th><th>Gender</th>
<th>Favourite Language</th><th>Country</th><th>Action</th>
</tr>
<!--  data row -->
<c:forEach var="student" items="${students}">
<tr>
<td>${student.id}</td>
<td>${student.firstName}</td>
<td>${student.lastName}</td>
<td>${student.gender}</td>
<td>
<c:forEach var="lang" items="${student.favlang}">
${lang}
</c:forEach>
</td>
<td>${student.country}</td>

<td>
<a href="editstudent/${student.id}"> Edit</a> || 
<a href="deletestudent/${student.id}">Delete</a>
</td>
</tr>
</c:forEach>
</table>
</body>
</html>