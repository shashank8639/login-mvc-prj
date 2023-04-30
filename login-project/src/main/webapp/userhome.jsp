<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

		


</head>
<body>
		
    <% 		if(session==null){
    	response.sendRedirect("login.jsp");
    }
    
		Object o=session.getAttribute("email");
			if(o==null){
				response.sendRedirect("login.jsp");
			}
		
		     %>
				<center> <h1> <a  href="users">View Users</a> </h1>   </center>
				<br>
								<center> <h1> <a  href="logout">LOGOUT</a> </h1>   </center>
				
</body>
</html>