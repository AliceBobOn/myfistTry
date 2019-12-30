package com.spring.controller;

import com.spring.dao.TuxiangfenleiMapper;
import com.spring.entity.Tuxiangfenlei;
import com.spring.service.TuxiangfenleiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import tk.mybatis.mapper.entity.Example;
import util.Request;
import util.Info;
import dao.Query;
import java.util.*;



/**
 * 图像分类 */
@Controller
public class TuxiangfenleiController extends BaseController
{
    @Autowired
    private TuxiangfenleiMapper dao;
    @Autowired
    private TuxiangfenleiService service;

    /**
     *  后台列表页
     *
     */
    @RequestMapping("/tuxiangfenlei_list")
    public String list()
    {
        if(!checkLogin()){
            return showError("尚未登录" , "./login.do");
        }

        String order = Request.get("order" , "id");
        String sort  = Request.get("sort" , "desc");

        Example example = new Example(Tuxiangfenlei.class);
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
        List<Tuxiangfenlei> list = service.selectPageExample(example , page , 12);
        request.setAttribute("list" , list);
        assign("orderBy" , order);
        assign("sort" , sort);
        assign("where" , where);
        return "tuxiangfenlei_list";
    }

    public String getWhere()
    {
        String where = " ";

            if(!Request.get("fenleimingcheng").equals("")) {
            where += " AND fenleimingcheng LIKE '%"+Request.get("fenleimingcheng")+"%' ";
        }
            return where;
    }





        @RequestMapping("/tuxiangfenlei_add")
    public String add()
    {
        return "tuxiangfenlei_add";
    }



    @RequestMapping("/tuxiangfenlei_updt")
    public String updt()
    {
        int id = Request.getInt("id");
        Tuxiangfenlei mmm = service.find(id);
        request.setAttribute("mmm" , mmm);
        request.setAttribute("updtself" , 0);
        return "tuxiangfenlei_updt";
    }
    /**
     * 添加内容
     * @return
     */
    @RequestMapping("/tuxiangfenleiinsert")
    public String insert()
    {
        Tuxiangfenlei post = new Tuxiangfenlei();
        post.setFenleimingcheng(Request.get("fenleimingcheng"));


        post.setAddtime(Info.getDateStr());
                service.insert(post);
        int charuid = post.getId().intValue();
        
        return showSuccess("保存成功" , Request.get("referer").equals("") ? request.getHeader("referer") : Request.get("referer"));
    }

    /**
    * 更新内容
    * @return
    */
    @RequestMapping("/tuxiangfenleiupdate")
    public String update()
    {
        Tuxiangfenlei post = new Tuxiangfenlei();
        if(!Request.get("fenleimingcheng").equals(""))
        post.setFenleimingcheng(Request.get("fenleimingcheng"));
        
        post.setId(Request.getInt("id"));
                service.update(post);
        int charuid = post.getId().intValue();
        
        if(Request.getInt("updtself") == 1){
            return showSuccess("保存成功" , "tuxiangfenlei_updtself.do");
        }
        return showSuccess("保存成功" , Request.get("referer"));
    }
        /**
    *  删除
    */
    @RequestMapping("/tuxiangfenlei_delete")
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
