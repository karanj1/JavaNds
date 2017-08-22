package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Next
 */
@WebServlet("/Next")
public class Next extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletContext ctx;
	String s;
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		ctx = config.getServletContext();
	   	   s = ctx.getInitParameter("driName");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.println("Major version for servlet API : " +ctx.getMajorVersion());
		out.print("<br> ");
		out.println("Minor version for servlet API : " +ctx.getMinorVersion());
		out.print("<br> ");
		ctx.setAttribute("MyData", "MyValueNextPage");
		//ctx=getServletContext(); // ServletContext is used to access context parameters which are common for all the servlets
		
		out.println("Attribute value : "+ctx.getAttribute("MyData"));
		out.print("<br> ");
		
		Enumeration<String> e=ctx.getInitParameterNames();
		String str="";
		out.print("s = "+s);
		out.print("<br> ");
		while(e.hasMoreElements()){
			str=e.nextElement();
			out.print(str);
			out.print("&nbsp; : &nbsp;"+ctx.getInitParameter(str));
			out.print("<br> ");
			
		}
		
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
