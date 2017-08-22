package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginSvlt
 */
@WebServlet("/LoginSvlt")
public class LoginSvlt extends HttpServlet {
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
		String u=request.getParameter("userName");
		String p=request.getParameter("userPass");
		if(p.equals("servlet")&& u.equals("scott")){
			
			RequestDispatcher rd=request.getRequestDispatcher("WelcomeServlet"); // welcome is url in web.xml , which is mapped to WelcomeServlet
			rd.forward(request, response);
			
		}
		else{
			out.print("Sorry username or password error!<br><br>");
			RequestDispatcher rd=request.getRequestDispatcher("/LoginSvlt.html");
			rd.include(request, response);
		}
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
