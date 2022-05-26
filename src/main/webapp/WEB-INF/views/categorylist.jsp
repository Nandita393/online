<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category-List</title>
</head>
<body>
<H1>Category List</H1>
<h2><a href="add">Add Category</a></h2>
<center>
<form action="search" >
Search:<input type="text" name="catname" id="catname" placeholder="first 3 charcater of category">
<input type="submit" value="Submit">
</form>
</center>
<table border="1" cellspacing="0" cellpadding="10">
<tr>
<th>ID</th><th>Category Name</th><th>Action</th>
</tr>
<!--  data row -->
<c:forEach var="category" items="${categories}">
<tr>
<td>${category.categoryId}</td>
<td>${category.categoryName}</td>

<td>
<a href="update/${category.categoryId}"> Edit</a> || 
<a href="delete/${category.categoryId}">Delete</a>
</td>
</tr>
</c:forEach>
</table>
</body>
</html>