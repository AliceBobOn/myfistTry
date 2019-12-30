package com.main;

import org.springframework.web.servlet.ModelAndView;

public class Response {
    protected ModelAndView vars    = null;

    public Response(String template)
    {
        vars = new ModelAndView();
        vars.setViewName(template);
    }

    public void assign(String name , Object value)
    {
        vars.addObject(name , value);
    }

    public ModelAndView getData()
    {
        return vars;
    }
}
