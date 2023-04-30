<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

		<%  response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-control", "no-store");
			response.setHeader("Expires","0");
			response.setDateHeader("Expires", -1);
			
				%>

</head>
<body>

	<fieldset>
		<legend>LOGIN</legend>
		<form action="login">

			Username <input type="email" name="email"> <br> Password
			<input type="password" name="password"> <br> <input
				type="submit">

		</form>

	</fieldset>

</body>
</html>