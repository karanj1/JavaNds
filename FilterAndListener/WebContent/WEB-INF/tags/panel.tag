<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ attribute name="color" %>
<%@ attribute name="bgcolor" %>
<%@ attribute name="title" %>

<table border="1" bgcolor="${color}">
	<tr>
		<th>${title}</th>
	</tr>
	<tr>
		<td bgcolor="${bgcolor}">
			<jsp:doBody/>
	
		</td>
	</tr>
</table>
Demo...