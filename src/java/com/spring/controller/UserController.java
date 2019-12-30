package com.spring.controller;

import com.spring.entity.Allusers;
import com.spring.service.AllusersService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import util.Request;
import com.spring.entity.Zhuceyonghu;
import com.spring.service.ZhuceyonghuService;


@Controller
public class UserController extends BaseController{

    @Resource
    private AllusersService allusersService;

        @Resource
    private ZhuceyonghuService zhuceyonghuService;
    
    /**
     * 登录页面
     * @return
     */
    @RequestMapping("/login")
    public String Index()
    {
        return "login";
    }

    /**
     * 退出
     * @return
     */
    @RequestMapping("/logout")
    public String Logout()
    {
        request.getSession().invalidate();
        return showSuccess("退出成功" , "./");
    }

    protected String authLoginUser(boolean isAdmin,String username , String pwd,String cx)
    {
        if(username == null || "".equals(username) ){
            return showError( "账号不允许为空" );
        }
        if(pwd == null || "".equals(pwd) ){
            return showError( "密码不允许为空" );
        }
        if(cx == null){
            return showError( "请选中登录类型" );
        }

        String random = (String) request.getSession().getAttribute("random");
        String pagerandom = request.getParameter("pagerandom") == null ? "" : request.getParameter("pagerandom");

        if(request.getParameter("a") !=null && !pagerandom.equals(random)){
            return showError( "验证码不正确" );
        }

        if(cx.equals("管理员")){
            Allusers user = null;
            user = allusersService.login(username , pwd);
            if(user == null){
                return showError("用户名或密码错误");
            }
            HttpSession session = request.getSession();
            session.setAttribute("id" , user.getId());
            session.setAttribute("username" , user.getUsername());
            session.setAttribute("cx" , user.getCx());
        }
        else if (cx.equals("注册用户")) {
            Zhuceyonghu user = zhuceyonghuService.login(username , pwd);
            if(user == null){
                return showError("用户名或密码错误");
            }
                        if(!user.getIssh().equals("是")){
                return showError("账号尚未激活请联系管理员激活");
            }
                                    session.setAttribute("yonghuming", user.getYonghuming());
                        session.setAttribute("mima", user.getMima());
                        session.setAttribute("xingming", user.getXingming());
                        session.setAttribute("xingbie", user.getXingbie());
                        session.setAttribute("dianhua", user.getDianhua());
                        session.setAttribute("youxiang", user.getYouxiang());
                        session.setAttribute("touxiang", user.getTouxiang());
                        session.setAttribute("dizhi", user.getDizhi());
                        session.setAttribute("beizhu", user.getBeizhu());
                        session.setAttribute("id" , user.getId());
            session.setAttribute("username" , user.getYonghuming());
            session.setAttribute("cx" , cx);
        }

        String referer = request.getParameter("referer");
        if(referer == null){
            if(isAdmin){
                referer = "./main.do";
            }else{
                referer = "./";
            }
        }
        return showSuccess("登录成功" , referer);
    }
    @RequestMapping("/main")
    public String main() {
        return "main";
    }
    @RequestMapping("/sy")
    public String sy() {
        return "sy";
    }

    @RequestMapping("/mygo")
    public String mygo() {
        return "mygo";
    }
    @RequestMapping("/top")
    public String top() {
        return "top";
    }
    @RequestMapping("/authLogin")
    public String authLogin()
    {
        String username = Request.get("username");
        String pwd  = Request.get("pwd");
        String cx = Request.get("cx");
        return authLoginUser(false , username,pwd,cx);
    }

    @RequestMapping("/authAdminLogin")
    public String authAdminLogin()
    {
        String username = Request.get("username");
        String pwd  = Request.get("pwd");
        String cx = Request.get("cx");
        return authLoginUser(true , username,pwd,cx);
    }

    @RequestMapping("/mod")
    public String mod()
    {
        return "mod";
    }

    @RequestMapping("/editPassword")
    public String editPassword()
    {
        String username = request.getSession().getAttribute("username").toString();
        String cx = request.getSession().getAttribute("cx").toString();
        String oldPassword = Request.get("oldPassword");
        String newPwd  = Request.get("newPwd");
        String newPwd2 = Request.get("newPwd2");

        if(!newPwd.equals(newPwd2)){
            return showError("两次密码不一致");
        }
        if(cx.equals("超级管理员") || cx.equals("普通管理员")){
            Allusers user = null;
            user = allusersService.login(username , oldPassword);
            if(user == null){
                return showError("原密码不正确");
            }
            allusersService.updatePassword(user.getId() , newPwd);
        }

else if (cx.equals("注册用户")) {
            Zhuceyonghu user = zhuceyonghuService.login(username , oldPassword);
            if(user == null){
                return showError("原密码不正确");
            }
            zhuceyonghuService.updatePassword(user.getId() , newPwd);
        }
        return showSuccess("修改密码成功" , "./mod.do");
    }
}
