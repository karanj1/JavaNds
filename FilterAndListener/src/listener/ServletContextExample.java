package listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ServletContextExample
 *
 */
@WebListener
public class ServletContextExample implements ServletContextListener {
	ServletContext context;
    /**
     * Default constructor. 
     */
    public ServletContextExample() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
    	System.out.println("...........Context Destroyed"); //This msg will be displayed in console
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
    	System.out.println("...........Context Created");
		context = arg0.getServletContext();
		// set variable to servlet context
		context.setAttribute("TEST", "TEST_VALUE_ForContext"); // string name , object value
    }
	
}
