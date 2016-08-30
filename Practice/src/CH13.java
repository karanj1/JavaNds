import java.applet.Applet;
import java.awt.Graphics;
import java.net.*;  // URL

public class CH13 extends Applet {
	
	
	// Called first.
	  public void init()
	  {
		  System.out.println("init");
	      // initialization
	  }

		 /* Called second, after init().  Also called whenever
	     the applet is restarted. */
		public void start() 
		{
		  	  System.out.println("start");
			  // start or resume execution
	    } 
	  

	  // Called when the applet is stopped.
	  public void stop() 
	  {
		  	  System.out.println("stop");		  
				// suspends execution
	  }
	  
	
	   // Called when an applet's window must be restored.
	  public void paint(Graphics g) {
			// TODO Auto-generated method stub
			g.drawString("Hi there " , 20, 40);
			
			String msg;
			URL url = getCodeBase(); // get code base , location of .class file
			msg = "Code base: " + url.toString();
			g.drawString(msg, 10, 60);
			url = getDocumentBase(); // get document base, location of .html or .java file
			msg = "Document base: " + url.toString();
			g.drawString(msg, 10, 90);
		}

	  /* Called when applet is terminated.  This is the last
	     method executed. */
	  public void destroy() 
	  {
		  	  System.out.println("destroy");
			  // perform shutdown activities
	  } 
	
	}