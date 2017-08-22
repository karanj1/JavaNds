
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
 * Servlet Filter implementation class MyFilter3
 */
@WebFilter(
		urlPatterns = { "/MyFilter3" }, 
		initParams = { 
				@WebInitParam(name = "construction", value = "no")	//change with "yes" and see the results
		}, 
		servletNames = { "Servlet1" })
public class MyFilter3 implements Filter {
	FilterConfig config;

    /**
     * Default constructor. 
     */
    public MyFilter3() {
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
		
		String s=config.getInitParameter("construction");
		
		if(s.equals("yes")){
			out.print("This page is under construction");
		}
		
		else{
		chain.doFilter(request, response);//sends request to next resource
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.config=fConfig;
	}

}
