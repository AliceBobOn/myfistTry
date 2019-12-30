package util.tld;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class IfTag extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
        PageContext content = (PageContext) getJspContext();


    }
}
