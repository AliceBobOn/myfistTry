package com.spring.controller;

import com.spring.entity.Pinglun;
import com.spring.service.PinglunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import util.Info;
import util.Request;

import javax.servlet.ServletOutputStream;
import java.io.PrintWriter;

@Controller
public class CommentController extends BaseController {
    @Autowired
    PinglunService service;
    @RequestMapping("/comment")
    public String index()
    {
        if( !checkLogin() ){
            try{
                //response.setContentType("image/jpeg");
                response.setHeader("content-type", "text/html;charset=UTF-8");
                response.setHeader("Pragma","No-cache");
                response.setHeader("Cache-Control","no-cache");
                response.setDateHeader("Expires", 0);
                //ServletOutputStream stream = response.getOutputStream();
                String string = "<script>alert('请登录');parent.window.location.reload();</script>";
                //stream.write(new Byte(string));
                PrintWriter out = response.getWriter();
                out.print(string);
                out.flush();
                out.close();
            }catch (Exception e){

            }
            return "success";
            //return showError("请登录");
        }
        assign("id" , Request.get("id"));
        assign("biao" , Request.get("biao"));
        return "comment";
    }

    @RequestMapping("/commentSave")
    public String save()
    {
        Pinglun pinlun = new Pinglun();
        pinlun.setBiao(Request.get("biao"));
        pinlun.setWenzhangid(Request.getInt("wenzhangID"));
        pinlun.setAddtime(Info.getDateStr());
        pinlun.setPingfen(Request.getInt("pingfen"));
        pinlun.setPinglunneirong(Request.get("pinglunneirong"));
        pinlun.setPinglunren(Request.get("pinglunren"));

        service.insert(pinlun);
        try{
            response.setHeader("content-type", "text/html;charset=UTF-8");
            response.setHeader("Pragma","No-cache");
            response.setHeader("Cache-Control","no-cache");
            response.setDateHeader("Expires", 0);
            PrintWriter stream = response.getWriter();
            String string = "<script>alert('保存成功');parent.window.location.reload();</script>";
            stream.print(string);
            stream.flush();
            stream.close();
            return "success";
        }catch (Exception e){

        }
        return showError("保存失败");
    }
}
