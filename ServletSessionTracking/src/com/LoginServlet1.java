package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet1
 */
@WebServlet("/LoginServlet1")
public class LoginServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		
		request.getRequestDispatcher("link1.html").include(request, response);
		
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		
		if(password.equals("admin123")){
		out.print("Welcome, "+name);
		HttpSession session=request.getSession(); // IMP , new session is created
		session.setAttribute("name",name); // String name , Object value // it passes name as a object
										// it can pass any object i.e. array, linkedList which is identified by it id(string) i.e. "name","userlist"
		}
		else{
			out.print("Sorry, username or password error!");
			request.getRequestDispatcher("Login1.html").include(request, response);
		}
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
