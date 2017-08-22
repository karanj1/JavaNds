package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LogoutServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");

		request.getRequestDispatcher("link.html").include(request, response);


		Cookie ck[]=request.getCookies();	//request
		if(ck!=null){
			String name=ck[0].getValue();
			if(!name.equals("")||name!=null){
				Cookie ck1=new Cookie("name","");
				ck1.setMaxAge(0); // delete a cookie , life 0 seconds
				response.addCookie(ck1);	

				out.print("you are successfully logged out!");
			}
		}else{
			out.print("Please login first");
			request.getRequestDispatcher("login.html").include(request, response);
		}


		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
