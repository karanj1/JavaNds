package listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class SessionCounterListener
 *
 */
@WebListener
public class SessionCounterListener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
	private static int totalActiveSessions;
    public SessionCounterListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0) {
    	totalActiveSessions++;
		System.out.println("sessionCreated - add one session into counter");
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0) {
    	totalActiveSessions--;
		System.out.println("sessionDestroyed - deduct one session from counter");
    }
    public static int getTotalActiveSession(){
  		return totalActiveSessions;
  	  }
	
}
