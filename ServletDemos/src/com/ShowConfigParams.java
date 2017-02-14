package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowConfigParams
 */
@WebServlet(
		urlPatterns = { "/ShowConfigParams" }, 
		initParams = { 
				@WebInitParam(name = "username", value = "myPC"), 
				@WebInitParam(name = "password", value = "myPC"), 
				@WebInitParam(name = "database", value = "oracle")
		})
public class ShowConfigParams extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		

		
		ServletConfig config=getServletConfig();
		Enumeration<String> e=config.getInitParameterNames(); // limited to single servlet
			
		String str="";
		while(e.hasMoreElements()){
			str=e.nextElement();
			out.print("<br>Name: "+str);
			out.print("   value: "+config.getInitParameter(str));
		}
		
		String unm=config.getInitParameter("username"); // pass parameter name
		out.print("<br>User name is: "+unm);
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
