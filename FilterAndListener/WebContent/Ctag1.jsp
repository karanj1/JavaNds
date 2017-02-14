<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="tags" tagdir="/WEB-INF/tags" %> <%--tag dir --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<tags:HelloT sport="football">
			This is tag body...<br>
			Sum = ${2 + 3}
		</tags:HelloT>
		
		<br/>	<br/>
		
		<tags:panel color="yellow" bgcolor="cyan" title="Samsung Models">
					Model-1 <br>
					Model-2 <br>
					Model-3
		</tags:panel>
</body>
</html>