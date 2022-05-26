<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/style.css">
    </head>
    <body>
        <h1></h1>

        <a href="login">Login</a> ||  <a href="register">Sign Up</a> 
        || <a href="http://localhost:8089/MySpringMvc/student/showform">Student</a>
        ||<a href="http://localhost:8089/MySpringMvc/student/list">Student List</a>
         ||<a href="${pageContext.request.contextPath}/category/list">Category</a>
          ||<a href="${pageContext.request.contextPath}/item/list">Item</a>
          
         <!-- Heading -->
    
      <table cellspacing="0" cellpadding="10" width="100%">
      	<tr>
      	
      	<td>
      	<!--  Heading  -->
      	<table cellspacing="0" cellpadding="0" bgcolor="blue">
      		<tr>
      		<td width="10%">
      		<img src="${pageContext.request.contextPath}/resources/images/growth.jpg" height="100px" width="100px">
      		</td>
      		<td align="center">
      		<h1>Our Online Shopping</h1>
      		</td>
      		</tr>
      		<tr>
      		<td colspan="2"><hr color="white"></td>
      		</tr>
      		<tr>
      		<td colspan="2" class="menutd"><a class="menu" href="/">Home</a> <a class="menu" href="login">Login</a>   <a class="menu" href="register">Sign Up</a>
      		<a class="menu" href="aboutus">About Us</a>  
      		</td>
      		</tr>
      	</table>
      
      	</td>
      	</tr>
      	<tr>
      	<td>&nbsp;</td>
      	</tr>
      		<tr>
      	<td>
      	
      	<table width="100%" cellaspcing="0" cellapdding="10">
      	<tr>
      	<td align="center">
      	Select Category
      	</td>
      	</tr>
      	<tr>
      	<td align="center">
      	
		<select name="category">    
       <option value="-1">Select</option>

       <c:forEach items="${categories}" var="category">
       <option value="${category.categoryId}">${category.categoryName}</option>
      	 
       </c:forEach>
      </select>
 

      	</td>
      	</tr>
      	<tr>
      	<td align="center">
      	
		<input class="btn" type="submit" value="Search">

      	</td>
      	</tr>
      	</table>
      	</center>
      	</td>
      	</tr>
      	
      	
      	<tr>
      	<td align="center">
      	<h1> My Product</h1>
      	</tr>
      	<tr>
      
   
      	<td>
       
      	
      	<table border="1" cellspacing="0" cellpadding="10" width="100%">
      	<c:set var="divCount" scope="page" value="0"/>
      <c:forEach var="item" items="${items}">
       <c:if test="${divCount % 2 == 0}"> 
      	<tr>
      	<td style="text-align: center;">
      	
      	<table  cellspacing="0" cellpadding="10" width="100%">
      	<tr>
      	<td>
      	<h1>${item.itemName}</h1>
      	</td>
      	</tr>
      	<tr>
      	<td>
      	<h1><img class="img-rounded"  height="150" width="150" src="${item.filename}" /></h1>
      	</td>
      	</tr>
      	<tr>
      	<td>
      	<h1>${item.itemPrice}</h1>
      	</td>
      	</tr>
      	<tr>
      	<td>
      	<a href="itemdetails/${item.itemId}" class="menu">View Details</a>
      	<a href="addtocart/${item.itemId}" class="menu">Add To cart</a>
      	</td>
      	</tr>
      	
      	</table>
      	</td>
      	</c:if>
      	
      	 <c:if test="${divCount % 2 != 0}">  
      	<td style="text-align: center;">
      	
      	<table  cellspacing="0" cellpadding="10" width="100%">
      		
      	<tr>
      	<td>
      	<h1>${item.itemName}</h1>
      	</td>
      	</tr>
      	<tr>
      	<td>
      	<h1><img class="img-rounded"  height="150" width="150" src="${item.filename}" /></h1>
      	</td>
      	</tr>
      	<tr>
      	<td>
      	<h1>${item.itemPrice}</h1>
      	</td>
      	</tr>
      	<tr>
      	<td>
      	<a href="itemdetails/${item.itemId}" class="menu">View Details</a>
      	<a href="addtocart/${item.itemId}" class="menu">Add To cart</a>
      	</td>
      	</tr>
      	
      	</table>
     
      	</td>
      	
      	</tr>
      	</c:if>
     <c:set var="divCount" value="${divCount + 1}" />

      	</c:forEach>
      	
      </table>
      </td>
      </tr>
      </table>
    </body>
</html>
