package com.spring.controller;

import com.spring.entity.Allusers;
import com.spring.service.AllusersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import util.Info;
import util.Request;

@Controller
public class AdminController extends BaseController{
    @Autowired
    AllusersService service;

    @RequestMapping("/yhzhgl")
    public String yhzhgl()
    {
        if(!checkLogin()){
            return showError("尚未登录");
        }
        if(!session.getAttribute("cx").equals("超级管理员")){
            return showError("当前权限不足");
        }
        return "yhzhgl";
    }
    @RequestMapping("yhzhgl_insert")
    public String insert()
    {
        if(!checkLogin()){
            return showError("尚未登录");
        }
        Allusers allusers = new Allusers();
        allusers.setPwd(Request.get("pwd"));
        allusers.setUsername(Request.get("username"));
        allusers.setCx("普通管理员");
        allusers.setAddtime(Info.getDateStr());
        service.insert(allusers);
        return showSuccess("添加成功" , request.getHeader("referer"));
    }
    @RequestMapping("yhzhgl_delete")
    public String delete()
    {
        Integer id = Request.getInt("scid");
        service.delete(id);
        return showSuccess("删除成功" , request.getHeader("referer"));
    }


}
