<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
request.setAttribute("r1","requestVarVal");
 %>
<br>
Request Data : ${requestScope.r1}
<br>
Session Data : ${sessionScope.s1}
<br>
Application Data : ${applicationScope.a1}
<br>
Cookie Data :${cookie.c1.value }
<br>
Context Parameter :  ${initParam.username}
<br>
Init Parameters Data : <%=config.getInitParameter("IP1")%>
</body>
</html>