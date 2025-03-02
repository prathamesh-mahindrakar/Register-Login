<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="jakarta.servlet.http.HttpSession" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Logout</title>

<link rel="stylesheet" type="text/css" href="indexStyle.css">
</head>
<body>
 <%
        // Retrieve the session object
        HttpSession currentSession = request.getSession(false);
        
        if(currentSession != null){
        	currentSession.invalidate();
        }
        
        response.sendRedirect("index.html");
        
    %>
</body>
</html>