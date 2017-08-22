package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterUsr
 */
@WebServlet("/RegisterUsr")
public class RegisterUsr extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		String n=request.getParameter("userName");
		String p=request.getParameter("userPass");
		String e=request.getParameter("userEmail");
		String c=request.getParameter("userCity");
		
		try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","HR","password");
		PreparedStatement ps=con.prepareStatement("insert into MyStudentJava values(?,?,?)");
		ps.setString(2,n);
		ps.setString(1,p);
		ps.setString(3,c);
		
		int i=ps.executeUpdate(); // return update count
		if(i>0)
		out.print("<B>You are successfully registered...</B>");
		
			
		}catch (Exception e2) {System.out.println(e2);}
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}