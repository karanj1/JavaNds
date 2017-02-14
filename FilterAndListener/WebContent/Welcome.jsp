<%@page import="listener.SessionCounterListener"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% out.println("context attr : "); %>
<%=application.getAttribute("TEST")%>
<br>
<%="Session cntr = " +SessionCounterListener.getTotalActiveSession() %>
<br>
<a href="next.jsp">Nextpg</a>
</body>
</html>