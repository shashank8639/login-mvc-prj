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

				<form:form action="saveUser" modelAttribute="userModel">
				
				Name <form:input path="name"/> <br>
				Email <form:input path="email"/> <br>
				Password <form:input path="password"/> <br>
				Mob Number <form:input path="mobileNumber"/> <br>
				
				<input type="submit">
				</form:form>











</body>
</html>