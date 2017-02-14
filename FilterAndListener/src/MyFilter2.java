

import java.io.IOException;
import javax.servlet.Filter;
import java.io.PrintWriter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * Servlet Filter implementation class MyFilter2
 */
@WebFilter(
		urlPatterns = { 
				"/MyFilter2", 
				"/test.jsp"
		}, 
		initParams = { 
				@WebInitParam(name = "param1", value = "12345")
		})
public class MyFilter2 implements Filter {
	FilterConfig fc;
    /**
     * Default constructor. 
     */
    public MyFilter2() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		PrintWriter out=response.getWriter();
		out.println("Pre processing <br>");
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
		
		String s=fc.getInitParameter("param1");
		out.println("<br> Post processing , s = "+s);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		fc=fConfig;
	}

}
