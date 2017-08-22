<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%--//declaration tags <%! %> --%>
<%!
int a,b,c;
int cube(int n)
{
   return(n*n*n);
}
 %>
 
 <%--//scriptlet tags <% %> --%>
 <%
 for (int i=1;i<=3;i++){
	 out.println("<br>");
	 out.println(i);
 }

 out.println("<br>");out.println("<br>");
 out.println("This is JSP");
 
 a=5;
 b=10;
 c=a+b;
 out.println("<br>");out.println("<br>");
 %>
 
 <B> My Data </B> <br>
 <%--//expression tags <%= %> --%>
 <%= "Sum = " + c %>
 <br>
 <%= "cube of 5 is " + cube(5) %>
 <br>
 <% out.print("2 * 5 = " + 2*5); %>

</body>
</html>