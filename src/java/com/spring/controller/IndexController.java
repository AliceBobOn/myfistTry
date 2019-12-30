package com.spring.controller;


import com.spring.entity.Dx;
import com.spring.entity.Liuyanban;
import com.spring.service.AllusersService;
import com.spring.service.DxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import util.Info;
import util.Request;

import javax.annotation.Resource;
import java.util.HashMap;

@Controller
public class IndexController extends BaseController{
    @Resource
    private AllusersService userService;

    @Autowired
    private DxService dxService;

    // 首页
    @RequestMapping("/index")
    public String Index()
    {
        Dx liuyanban = new Dx();
        //liuyanban.setContent("测试");
        //liuyanban.setAddtime(Info.getDateStr());
        //liuyanban.setLeibie("测试");
        //dxService.insert(liuyanban);
        //int charuid = liuyanban.getId().intValue();
        //request.setAttribute("dx" , liuyanban.getId());
        liuyanban.setAddtime(Info.getDateStr());
        int id = Request.getInt("id");

        System.out.println(request);
        HashMap map = new HashMap();
        map.put("abc" , "a");
        request.setAttribute("map" , map);

        return "index";
    }



}
