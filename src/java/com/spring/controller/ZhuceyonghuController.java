package com.spring.controller;

import com.spring.dao.ZhuceyonghuMapper;
import com.spring.entity.Zhuceyonghu;
import com.spring.service.ZhuceyonghuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import tk.mybatis.mapper.entity.Example;
import util.Request;
import util.Info;
import dao.Query;
import java.util.*;



/**
 * 注册用户 */
@Controller
public class ZhuceyonghuController extends BaseController
{
    @Autowired
    private ZhuceyonghuMapper dao;
    @Autowired
    private ZhuceyonghuService service;

    /**
     *  后台列表页
     *
     */
    @RequestMapping("/zhuceyonghu_list")
    public String list()
    {
        if(!checkLogin()){
            return showError("尚未登录" , "./login.do");
        }

        String order = Request.get("order" , "id");
        String sort  = Request.get("sort" , "desc");

        Example example = new Example(Zhuceyonghu.class);
        Example.Criteria criteria = example.createCriteria();
        String where = " 1=1 ";
        where += getWhere();
        criteria.andCondition(where);
        if(sort.equals("desc")){
            example.orderBy(order).desc();
        }else{
            example.orderBy(order).asc();
        }
        int page = request.getParameter("page") == null ? 1 : Integer.valueOf(request.getParameter("page"));
        page = Math.max(1 , page);
        List<Zhuceyonghu> list = service.selectPageExample(example , page , 12);
        request.setAttribute("list" , list);
        assign("orderBy" , order);
        assign("sort" , sort);
        assign("where" , where);
        return "zhuceyonghu_list";
    }

    public String getWhere()
    {
        String where = " ";

            if(!Request.get("yonghuming").equals("")) {
            where += " AND yonghuming LIKE '%"+Request.get("yonghuming")+"%' ";
        }
                if(!Request.get("xingming").equals("")) {
            where += " AND xingming LIKE '%"+Request.get("xingming")+"%' ";
        }
                if(!Request.get("xingbie").equals("")) {
            where += " AND xingbie ='"+Request.get("xingbie")+"' ";
        }
                if(!Request.get("dianhua").equals("")) {
            where += " AND dianhua LIKE '%"+Request.get("dianhua")+"%' ";
        }
                if(!Request.get("youxiang").equals("")) {
            where += " AND youxiang LIKE '%"+Request.get("youxiang")+"%' ";
        }
                if(!Request.get("dizhi").equals("")) {
            where += " AND dizhi LIKE '%"+Request.get("dizhi")+"%' ";
        }
                if(!Request.get("beizhu").equals("")) {
            where += " AND beizhu LIKE '%"+Request.get("beizhu")+"%' ";
        }
            return where;
    }





        @RequestMapping("/zhuceyonghu_add")
    public String add()
    {
        return "zhuceyonghu_add";
    }

    @RequestMapping("/zhuceyonghuadd")
    public String addWeb()
    {
        return "zhuceyonghuadd";
    }


    @RequestMapping("/zhuceyonghu_updt")
    public String updt()
    {
        int id = Request.getInt("id");
        Zhuceyonghu mmm = service.find(id);
        request.setAttribute("mmm" , mmm);
        request.setAttribute("updtself" , 0);
        return "zhuceyonghu_updt";
    }
    @RequestMapping("/zhuceyonghu_updtself")
    public String updtself()
    {
        int id = (int)request.getSession().getAttribute("id");
        Zhuceyonghu mmm = service.find(id);
        request.setAttribute("mmm" , mmm);
        request.setAttribute("updtself" , 1);

        return "zhuceyonghu_updtself";
    }
    /**
     * 添加内容
     * @return
     */
    @RequestMapping("/zhuceyonghuinsert")
    public String insert()
    {
        Zhuceyonghu post = new Zhuceyonghu();
        post.setYonghuming(Request.get("yonghuming"));

        post.setMima(Request.get("mima"));

        post.setXingming(Request.get("xingming"));

        post.setXingbie(Request.get("xingbie"));

        post.setDianhua(Request.get("dianhua"));

        post.setYouxiang(Request.get("youxiang"));

        post.setTouxiang(Request.get("touxiang"));

        post.setDizhi(Request.get("dizhi"));

        post.setBeizhu(Request.get("beizhu"));

        post.setIssh("否");

        post.setAddtime(Info.getDateStr());
                service.insert(post);
        int charuid = post.getId().intValue();
        
        return showSuccess("保存成功" , Request.get("referer").equals("") ? request.getHeader("referer") : Request.get("referer"));
    }

    /**
    * 更新内容
    * @return
    */
    @RequestMapping("/zhuceyonghuupdate")
    public String update()
    {
        Zhuceyonghu post = new Zhuceyonghu();
        if(!Request.get("yonghuming").equals(""))
        post.setYonghuming(Request.get("yonghuming"));
                if(!Request.get("mima").equals(""))
        post.setMima(Request.get("mima"));
                if(!Request.get("xingming").equals(""))
        post.setXingming(Request.get("xingming"));
                if(!Request.get("xingbie").equals(""))
        post.setXingbie(Request.get("xingbie"));
                if(!Request.get("dianhua").equals(""))
        post.setDianhua(Request.get("dianhua"));
                if(!Request.get("youxiang").equals(""))
        post.setYouxiang(Request.get("youxiang"));
                if(!Request.get("touxiang").equals(""))
        post.setTouxiang(Request.get("touxiang"));
                if(!Request.get("dizhi").equals(""))
        post.setDizhi(Request.get("dizhi"));
                if(!Request.get("beizhu").equals(""))
        post.setBeizhu(Request.get("beizhu"));
        
        post.setId(Request.getInt("id"));
                service.update(post);
        int charuid = post.getId().intValue();
        
        if(Request.getInt("updtself") == 1){
            return showSuccess("保存成功" , "zhuceyonghu_updtself.do");
        }
        return showSuccess("保存成功" , Request.get("referer"));
    }
        /**
    *  删除
    */
    @RequestMapping("/zhuceyonghu_delete")
    public String delete()
    {
        if(!checkLogin()){
            return showError("尚未登录");
        }
        int id = Request.getInt("id");
        //delete_before
                service.delete(id);
                return showSuccess("删除成功",request.getHeader("referer"));
    }
}
