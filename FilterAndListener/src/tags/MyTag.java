package tags;


import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;



public class MyTag extends TagSupport {
@Override
public int doStartTag() throws JspException {
	// TODO Auto-generated method stub
	try {
		pageContext.getOut().write("<p>Tag start info ...<br/>");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//return EVAL_BODY_INCLUDE;
	return SKIP_BODY;
}

@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
	try {
		pageContext.getOut().write("<br/>Closing Tag info .<br/>");
 } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 return EVAL_PAGE ;
 //return SKIP_PAGE;
	}
}