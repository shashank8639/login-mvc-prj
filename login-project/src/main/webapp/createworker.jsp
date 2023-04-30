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
			<%  Integer value=(Integer)session.getAttribute("Id");  %>

		<form:form action="saveWorker" method="post" modelAttribute="workermodel">
		
		Name  <form:input path="workerName"/> <br>
		Email <form:input path="email"/> <br>
		
		Password <form:password path="password" /> <br>
		
		Admin Id <input type="number" value="<%=value %>" readonly="true"/> <br>
		<input type="submit">
		
		</form:form>

</body>
</html>