package tags;

import java.io.IOException;
import java.io.StringWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;



public class TagWithAttr extends SimpleTagSupport {
private String message; // attribute , declare variable for attribute
	
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
	
StringWriter sw=new StringWriter(); // writer stream to store body content
@Override
public void doTag() throws JspException, IOException {
	// TODO Auto-generated method stub
	 if (message != null) {
		    /* Use message from attribute */
		    
				   getJspContext().getOut().println( "message : " + message );
		 }
	getJspBody().invoke(sw);// catch the body content ,  directs all output to the given Writer
	getJspContext().getOut().println("<br> using Custom Tag!<br>"); // your logic
	getJspContext().getOut().println("Body Content : " + sw.toString());// display body content
}
}
