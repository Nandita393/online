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

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

	<a href="javascript:history.go(-1)" class="btn btn-info">Go Back</a><br/>

	<h1>Register a New Product</h1>

<div>

<form:form action="${contextPath}/item/save" modelAttribute="product" method="post" >

	<form:hidden path="filename"/>
	<form:hidden path="itemId"/>
		<table border="1" cellspacing="0" cellpadding="10">
		<tr>
		<td>Category Name </td><td>
 <form:select path="category.categoryId">    
       <option value="-1">Select a type</option>
       <c:forEach items="${categories}" var="category">
       <option value="${category.categoryId}"  ${product.category.categoryId == category.categoryId ? 'selected' : ''}>${category.categoryName}</option>
      	 
       </c:forEach>
      </form:select>
</td>
 		
 		</tr>
			<tr>
				<td>Item Name:</td>
				<td><form:input path="itemName" size="30" required="required" />
					<font color="red"></font></td>
			</tr>

			<tr>
				<td>Item Price:</td>
				<td><form:input path="itemPrice" size="30" required="required" />
					<font color="red"></font></td>
			</tr>
	
		<tr>
		<td>
		Select photo:</td><td> <input type="file" name="photo"/></td></tr>
		
		
		
			
		<tr>
			<td colspan="2"><input type="submit" value="Register Product" class="btn btn-info" /></td>
			</tr>
		</table>
	
	
	

	</form:form>
</div>

	

</body>
</html>