package com.spring.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 路由基类
 */
abstract public class BaseController {
    @Autowired
    protected HttpServletRequest request;
    @Autowired
    protected HttpServletResponse response;
    @Autowired
    protected HttpSession session;

    protected ModelAndView mView;
    BaseController()
    {
        //request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        //response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        mView = new ModelAndView();
    }

    protected void assign(String name , Object value)
    {

        request.setAttribute(name , value);
    }

    protected String showMessage( String message , int code , String jumpUrl , int jumpTime)
    {
        assign("message" , message);
        assign("code" , code);
        assign("jumpUrl" , jumpUrl);
        assign("jumpTime" , jumpTime);

        return "message";
    }

    protected boolean checkLogin()
    {
        if(request.getSession().getAttribute("username") == null || "".equals(request.getSession().getAttribute("username")))
        {
            return false;
        }
        return true;
    }


    protected String showError(String message)
    {
        return showMessage(message , 1 , "javascript:history(-1);" , 2250);
    }

    protected String showError(String message , int code)
    {
        return showMessage(message , code , "javascript:history(-1);" , 2250);
    }

    protected String showError(String message , String url)
    {
        return showMessage(message , 1 , url , 2250);
    }

    protected String showSuccess(String message )
    {
        return showMessage(message , 0 , request.getHeader("referer") , 2250);
    }

    protected String showSuccess(String message , String url)
    {
        return showMessage(message , 0 , url , 2250);
    }


}
