<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

			<table border="5">
				
				<tr>
					<th>S.no</th>
					<th>Name</th>
					<th>Email</th>
					<th>Password</th>
					<th>MobileNumber</th>
					<th colspan="2"></th>
				</tr>
				<% int count=1; %>
				<c:forEach var="user" items="${allusers }">
				
				<tr>
					<td> <%= count++ %>      </td>
					
					<td> ${user.name} </td>
					
					<td> ${user.email}</td>
					
					<td> ${user.password}</td>
					
					<td> ${user.mobileNumber}</td>
					
					<td> <a href="edit?emailId=${user.email}"><input type="submit" value="EDIT"></a> </td>
					
					<td> <a href="delete?emailId=${user.email}"><input type="submit" value="DELETE"></a> </td>
				</tr>
				
				</c:forEach>
				
				
				
				
				
				
				</table>

</body>
</html>