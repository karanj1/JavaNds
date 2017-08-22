<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:useBean id="fb" class="com.FormBean" scope="session">  </jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:setProperty property="*" name="fb"/>	<%--* takes values from JavaBean2.jsp and sets all properties on FormBean.java class  --%>

 Name :<jsp:getProperty property="name" name="fb"/>		<%--gets properties from FormBean.java, which was set in above line --%>
 <br> Age:     <jsp:getProperty property="age" name="fb"/>

  <br>
  <a href="other.jsp">Other pg</a>
</body>
</html>