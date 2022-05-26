<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Item List</h1>
<a href="additem">Add new Item</a>
<table border="1" cellspacing="1" cellpadding="10">
<tr>
<th>Item Id</th><th>Image</th><th>Item Name</th><th>Category Name</th><th>Item Price</th><th></th>
</tr>
<c:forEach var="item" items="${items}">
<tr>

<td>${item.itemId}
<td><img class="img-rounded"  height="150" width="150" src="${item.filename}" /></td>
<td>${item.itemName}</td>
<td>${item.category.categoryName}</td>
<td>${item.itemPrice}
<td><a href="edititem/${item.itemId}">Edit</a> || 
<a href="deletetem/${item.itemId}" onclick="return confirm('Are you sure you want to delete this record?')">Delete</a>
</tr>
</c:forEach>
</table>
</body>
</html>