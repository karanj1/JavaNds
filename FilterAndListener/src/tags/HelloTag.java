package tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class HelloTag extends SimpleTagSupport {
@Override
public void doTag() throws JspException, IOException {
	// TODO Auto-generated method stub
JspWriter out = getJspContext().getOut();
	
    out.println("Hello Using Custom Tag!");
}
}
