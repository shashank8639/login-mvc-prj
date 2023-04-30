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

				<table border="4">
		
			<tr>
				<th>S.no</th>
				<th>Food Name</th>
				<th>Cost</th>
				<th>Description</th>
				<th colspan="2">   </th>
			</tr>
		
			<c:forEach var="p" items="${products }">
			
			<tr>
				<th>${p.id }</th>
				<th>${p.foodName }</th>
				<th>${p.cost }</th>
				<th>${p.description }</th>
				<th>  <a href="editFoodProduct?id=${p.id }">  <input type="submit" value="EDIT"> </a>  </th>
				<th>  <a href="deleteFoodProduct?id=${p.id }">  <input type="submit" value="DELETE"> </a>  </th>
			</tr>
			
			</c:forEach>
		</table>
			<br>
			<center>  <a href="createProduct">  <input type="submit" value="Add Product"> </a> </center>

</body>
</html>