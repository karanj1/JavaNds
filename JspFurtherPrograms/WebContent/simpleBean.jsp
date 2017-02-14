<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="person" class="com.UseFormBean" scope="request"></jsp:useBean>
						<%--Scope is not "session", so data wont be available to next hyperlinked page --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>
</head>
<body>

<jsp:setProperty property="*" name="person"/> <%--* takes values from JavaBean3.jsp and sets all properties on UseFormBean.java class  --%>
Name : ${person.name}	<%--gets properties from UseFormBean.java, which was set in above line --%>
<br>
Age : ${person.age}		<%--EL: expression Language syntax //it replaces request.getparameter("age") --%>

<br>
<br>


Calculation (2*5) = ${2*5}
<br>
2&lt;5 ? ${2<5}

<br>
 <a href="NextPg.jsp">nextPg</a>	<%--Scope is not "session", so data wont be available to next hyperlinked page --%>
 									<%-- so we dont need to do "session.invalidate();" as we did in other.jsp --%>
</body>
</html>