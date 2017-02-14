<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="person" class="com.UseFormBean" scope="request"></jsp:useBean>	<%--Scope is not "session", so data wont be available from previous page --%>
Name : ${person.name}
<br>
Age : ${person.age}

<br>
</body>
</html>