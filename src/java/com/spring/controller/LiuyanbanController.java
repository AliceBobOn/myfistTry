package com.spring.controller;

import com.spring.dao.LiuyanbanMapper;
import com.spring.entity.Liuyanban;
import com.spring.service.LiuyanbanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import tk.mybatis.mapper.entity.Example;
import util.Request;
import util.Info;
import dao.Query;
import java.util.*;



/**
 * 留言板 */
@Controller
public class LiuyanbanController extends BaseController
{
    @Autowired
    private LiuyanbanMapper dao;
    @Autowired
    private LiuyanbanService service;

    /**
     *  后台列表页
     *
     */
    @RequestMapping("/liuyanban_list")
    public String list()
    {
        if(!checkLogin()){
            return showError("尚未登录" , "./login.do");
        }

        String order = Request.get("order" , "id");
        String sort  = Request.get("sort" , "desc");

        Example example = new Example(Liuyanban.class);
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
        List<Liuyanban> list = service.selectPageExample(example , page , 12);
        request.setAttribute("list" , list);
        assign("orderBy" , order);
        assign("sort" , sort);
        assign("where" , where);
        return "liuyanban_list";
    }

    public String getWhere()
    {
        String where = " ";

        return where;
    }





        @RequestMapping("/liuyanban_add")
    public String add()
    {
        return "liuyanban_add";
    }

    @RequestMapping("/liuyanbanadd")
    public String addWeb()
    {
        return "liuyanbanadd";
    }


    @RequestMapping("/liuyanban_updt")
    public String updt()
    {
        int id = Request.getInt("id");
        Liuyanban mmm = service.find(id);
        request.setAttribute("mmm" , mmm);
        request.setAttribute("updtself" , 0);
        return "liuyanban_updt";
    }
    /**
     * 添加内容
     * @return
     */
    @RequestMapping("/liuyanbaninsert")
    public String insert()
    {
        Liuyanban post = new Liuyanban();
        post.setXingming(Request.get("xingming"));

        post.setLianxidianhua(Request.get("lianxidianhua"));

        post.setLiuyanneirong(Request.get("liuyanneirong"));

        post.setHuifuneirong(Request.get("huifuneirong"));


        post.setAddtime(Info.getDateStr());
                service.insert(post);
        int charuid = post.getId().intValue();
        
        return showSuccess("保存成功" , Request.get("referer").equals("") ? request.getHeader("referer") : Request.get("referer"));
    }

    /**
    * 更新内容
    * @return
    */
    @RequestMapping("/liuyanbanupdate")
    public String update()
    {
        Liuyanban post = new Liuyanban();
        if(!Request.get("xingming").equals(""))
        post.setXingming(Request.get("xingming"));
                if(!Request.get("lianxidianhua").equals(""))
        post.setLianxidianhua(Request.get("lianxidianhua"));
                if(!Request.get("liuyanneirong").equals(""))
        post.setLiuyanneirong(Request.get("liuyanneirong"));
                if(!Request.get("huifuneirong").equals(""))
        post.setHuifuneirong(Request.get("huifuneirong"));
        
        post.setId(Request.getInt("id"));
                service.update(post);
        int charuid = post.getId().intValue();
        
        if(Request.getInt("updtself") == 1){
            return showSuccess("保存成功" , "liuyanban_updtself.do");
        }
        return showSuccess("保存成功" , Request.get("referer"));
    }
        /**
    *  删除
    */
    @RequestMapping("/liuyanban_delete")
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
