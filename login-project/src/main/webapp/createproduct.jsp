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

		<form:form action="saveProduct" method="post" modelAttribute="productmodel">
		
		FoodName  <form:input path="foodName"/> <br>
		Description <form:input path="description"/> <br>
		CostPrice <form:input path="cost"/> <br>
		Food Type <form:select path="foodType" title="Food Type" multiple="true" size="1">
						<form:option value="None" label="select"></form:option>
						<form:options items="${values }"/>
				</form:select>
				<br>
		
		Admin Id <input type="number" value="<%=value %>" readonly="true"/> <br>
		<input type="submit">
		
		</form:form>

		

</body>
</html>