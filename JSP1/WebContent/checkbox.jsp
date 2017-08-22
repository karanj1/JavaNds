<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%

String arr[]=request.getParameterValues("vehicle");
out.println("<br>Selected Vehicles <br>");
for(String s:arr)
{
out.println(s);
out.println("<br>");

}
out.println("<br>Do you like Java : " + request.getParameter("likejava"));
%>