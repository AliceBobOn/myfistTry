package com.spring.controller;

import com.spring.dao.LunbotuMapper;
import com.spring.entity.Lunbotu;
import com.spring.service.LunbotuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import tk.mybatis.mapper.entity.Example;
import util.Request;
import util.Info;
import dao.Query;
import java.util.*;



/**
 * 轮播图 */
@Controller
public class LunbotuController extends BaseController
{
    @Autowired
    private LunbotuMapper dao;
    @Autowired
    private LunbotuService service;

    /**
     *  后台列表页
     *
     */
    @RequestMapping("/lunbotu_list")
    public String list()
    {
        if(!checkLogin()){
            return showError("尚未登录" , "./login.do");
        }

        String order = Request.get("order" , "id");
        String sort  = Request.get("sort" , "desc");

        Example example = new Example(Lunbotu.class);
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
        List<Lunbotu> list = service.selectPageExample(example , page , 12);
        request.setAttribute("list" , list);
        assign("orderBy" , order);
        assign("sort" , sort);
        assign("where" , where);
        return "lunbotu_list";
    }

    public String getWhere()
    {
        String where = " ";

            if(!Request.get("title").equals("")) {
            where += " AND title LIKE '%"+Request.get("title")+"%' ";
        }
            return where;
    }





        @RequestMapping("/lunbotu_add")
    public String add()
    {
        return "lunbotu_add";
    }



    @RequestMapping("/lunbotu_updt")
    public String updt()
    {
        int id = Request.getInt("id");
        Lunbotu mmm = service.find(id);
        request.setAttribute("mmm" , mmm);
        request.setAttribute("updtself" , 0);
        return "lunbotu_updt";
    }
    /**
     * 添加内容
     * @return
     */
    @RequestMapping("/lunbotuinsert")
    public String insert()
    {
        Lunbotu post = new Lunbotu();
        post.setTitle(Request.get("title"));

        post.setImage(Request.get("image"));

        post.setUrl(Request.get("url"));


        post.setAddtime(Info.getDateStr());
                service.insert(post);
        int charuid = post.getId().intValue();
        
        return showSuccess("保存成功" , Request.get("referer").equals("") ? request.getHeader("referer") : Request.get("referer"));
    }

    /**
    * 更新内容
    * @return
    */
    @RequestMapping("/lunbotuupdate")
    public String update()
    {
        Lunbotu post = new Lunbotu();
        if(!Request.get("title").equals(""))
        post.setTitle(Request.get("title"));
                if(!Request.get("image").equals(""))
        post.setImage(Request.get("image"));
                if(!Request.get("url").equals(""))
        post.setUrl(Request.get("url"));
        
        post.setId(Request.getInt("id"));
                service.update(post);
        int charuid = post.getId().intValue();
        
        if(Request.getInt("updtself") == 1){
            return showSuccess("保存成功" , "lunbotu_updtself.do");
        }
        return showSuccess("保存成功" , Request.get("referer"));
    }
        /**
    *  删除
    */
    @RequestMapping("/lunbotu_delete")
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
