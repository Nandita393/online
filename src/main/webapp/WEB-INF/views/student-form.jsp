<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="http://localhost:8089/MySpringMvc/student/studentform" method="post" modelAttribute="student">
<table border="1" cellsspacing="0" cellpadding="10">
<tr>
<td>First Name :</td><td><form:input path="firstName"/>
<!-- create a hiiden field to store the id -->
<form:hidden path="Id"/>
</td>
</tr>
<tr>
<td>Last Name :</td><td><form:input path="lastName" />


</td>
</tr>
<tr>
<td>Gender :</td><td><form:radiobutton path="gender" value="Male"/>Male<form:radiobutton path="gender" value="Female"/>Female
</td>
</tr>
<tr>
<td>Favorite Language:</td><td><form:checkbox path="favlang" value="C"/>'C'
<form:checkbox path="favlang" value="Java"/>Java
<form:checkbox path="favlang" value="C#"/>C#
</td>
</tr>
<tr>
<td>Country:</td><td>
<form:select path="country">
<form:option value="0">Select Country</form:option>
<form:options items="${student.countryoptions}"/>
</form:select>
</td>
</tr>
<tr>
<td colspan="2"><input type="Submit" value="Submit"></td>
</table>
 
</form:form>
</body>
</html>