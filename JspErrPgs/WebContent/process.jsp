<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page errorPage="Error.jsp" %>
<%

String num1=request.getParameter("n1");
String num2=request.getParameter("n2");

int a=Integer.parseInt(num1);
int b=Integer.parseInt(num2);
int c=a/b;
out.print("division of numbers is: "+c);

int []arr={2,3};
arr[1]=8;


%>
<br>
<a href="a.jsp" > visit </a> <%-- If this page is not found it will throw a 404 error, which in this project will be redirected from web.xml to error-404.jsp page --%>
							<%--see web.xml file for error-404.jsp page --%>

