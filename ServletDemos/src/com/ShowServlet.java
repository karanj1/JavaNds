package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowServlet
 */
@WebServlet("/ShowServlet")
public class ShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");

		
		String cmd="Select * from MyStudentJava2 where Name = '"+request.getParameter("name")+ "'";
		out.println(cmd);
		
		ResultSet rs=null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			
			Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","HR","password");
			
			Statement smt=connection.createStatement();
			rs=	smt.executeQuery(cmd);
			while(rs.next())
			{
				out.println("<br>");
				out.println(rs.getString("RNO") + "\t\t");
				out.print(rs.getString("NAME"));
			}
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}