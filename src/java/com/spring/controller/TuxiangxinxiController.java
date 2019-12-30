package com.spring.controller;

import com.spring.dao.TuxiangxinxiMapper;
import com.spring.entity.Tuxiangxinxi;
import com.spring.service.TuxiangxinxiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import tk.mybatis.mapper.entity.Example;
import util.Request;
import util.Info;
import dao.Query;
import java.util.*;

import com.spring.dao.PinglunMapper;
import com.spring.service.PinglunService;
import com.spring.entity.Pinglun;


/**
 * 图像信息 */
@Controller
public class TuxiangxinxiController extends BaseController
{
    @Autowired
    private TuxiangxinxiMapper dao;
    @Autowired
    private TuxiangxinxiService service;

    @Autowired
    private PinglunMapper pinglunDao;
    @Autowired
    private PinglunService pinglunService;
    /**
     *  后台列表页
     *
     */
    @RequestMapping("/tuxiangxinxi_list")
    public String list()
    {
        if(!checkLogin()){
            return showError("尚未登录" , "./login.do");
        }

        String order = Request.get("order" , "id");
        String sort  = Request.get("sort" , "desc");

        Example example = new Example(Tuxiangxinxi.class);
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
        List<Tuxiangxinxi> list = service.selectPageExample(example , page , 12);
        request.setAttribute("list" , list);
        assign("orderBy" , order);
        assign("sort" , sort);
        assign("where" , where);
        return "tuxiangxinxi_list";
    }

    public String getWhere()
    {
        String where = " ";

            if(!Request.get("tuxiangbianhao").equals("")) {
            where += " AND tuxiangbianhao LIKE '%"+Request.get("tuxiangbianhao")+"%' ";
        }
                if(!Request.get("fenlei").equals("")) {
            where += " AND fenlei ='"+Request.get("fenlei")+"' ";
        }
                if(!Request.get("mingcheng").equals("")) {
            where += " AND mingcheng LIKE '%"+Request.get("mingcheng")+"%' ";
        }
                if(!Request.get("zuozhe").equals("")) {
            where += " AND zuozhe LIKE '%"+Request.get("zuozhe")+"%' ";
        }
            return where;
    }

    @RequestMapping("/tuxiangxinxi_list_zuozhe")
    public String listzuozhe()
    {
        if(!checkLogin()){
            return showError("尚未登录" , "./login.do");
        }
        String order = Request.get("order" , "id");
        String sort  = Request.get("sort" , "desc");

        Example example = new Example(Tuxiangxinxi.class);
        Example.Criteria criteria = example.createCriteria();
        String where = " zuozhe='"+request.getSession().getAttribute("username")+"' ";
        where += getWhere();

        criteria.andCondition(where);
        if(sort.equals("desc")){
            example.orderBy(order).desc();
        }else{
            example.orderBy(order).asc();
        }

        int page = request.getParameter("page") == null ? 1 : Integer.valueOf(request.getParameter("page"));
        page = Math.max(1 , page);
        List<Tuxiangxinxi> list = service.selectPageExample(example , page , 12);
        request.setAttribute("list" , list);
        assign("orderBy" , order);
        assign("sort" , sort);
        assign("where" , where);
        return "tuxiangxinxi_list_zuozhe";
    }


    /**
    *  前台列表页
    *
    */
    @RequestMapping("/tuxiangxinxilist")
    public String index()
    {
        if(!checkLogin()){
            return showError("尚未登录" , "./");
        }
        String order = Request.get("order" , "id");
        String sort  = Request.get("sort" , "desc");

        Example example = new Example(Tuxiangxinxi.class);
        Example.Criteria criteria = example.createCriteria();
        String where = " 1=1 ";
        where += " AND issh='是' ";
        where += getWhere();
        criteria.andCondition(where);
        if(sort.equals("desc")){
            example.orderBy(order).desc();
        }else{
            example.orderBy(order).asc();
        }
        int page = request.getParameter("page") == null ? 1 : Integer.valueOf(request.getParameter("page"));
        page = Math.max(1 , page);
        List<Tuxiangxinxi> list = service.selectPageExample(example , page , 12);
        request.setAttribute("list" , list);
        request.setAttribute("where" , where);
        assign("orderBy" , order);
        assign("sort" , sort);
        return "tuxiangxinxilist";
    }


        @RequestMapping("/tuxiangxinxi_add")
    public String add()
    {
        return "tuxiangxinxi_add";
    }

    @RequestMapping("/tuxiangxinxiadd")
    public String addWeb()
    {
        if(!checkLogin()){
            return showError("尚未登录" , "./");
        }
        return "tuxiangxinxiadd";
    }


    @RequestMapping("/tuxiangxinxi_updt")
    public String updt()
    {
        int id = Request.getInt("id");
        Tuxiangxinxi mmm = service.find(id);
        request.setAttribute("mmm" , mmm);
        request.setAttribute("updtself" , 0);
        return "tuxiangxinxi_updt";
    }
    /**
     * 添加内容
     * @return
     */
    @RequestMapping("/tuxiangxinxiinsert")
    public String insert()
    {
        Tuxiangxinxi post = new Tuxiangxinxi();
        post.setTuxiangbianhao(Request.get("tuxiangbianhao"));

        post.setFenlei(Request.get("fenlei"));

        post.setTupian(Request.get("tupian"));

        post.setMingcheng(Request.get("mingcheng"));

        post.setShiping(Request.get("shiping"));

        post.setZuozhe(Request.get("zuozhe"));

        post.setDianjishuai(Request.getInt("dianjishuai"));

        post.setNeirongjianjie(util.DownloadRemoteImage.run(Request.get("neirongjianjie")));

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
    @RequestMapping("/tuxiangxinxiupdate")
    public String update()
    {
        Tuxiangxinxi post = new Tuxiangxinxi();
        if(!Request.get("tuxiangbianhao").equals(""))
        post.setTuxiangbianhao(Request.get("tuxiangbianhao"));
                if(!Request.get("fenlei").equals(""))
        post.setFenlei(Request.get("fenlei"));
                if(!Request.get("tupian").equals(""))
        post.setTupian(Request.get("tupian"));
                if(!Request.get("mingcheng").equals(""))
        post.setMingcheng(Request.get("mingcheng"));
                if(!Request.get("shiping").equals(""))
        post.setShiping(Request.get("shiping"));
                if(!Request.get("zuozhe").equals(""))
        post.setZuozhe(Request.get("zuozhe"));
            if(Request.getInt("dianjishuai")>0)
        post.setDianjishuai(Request.getInt("dianjishuai"));
            if(!Request.get("neirongjianjie").equals(""))
        post.setNeirongjianjie(util.DownloadRemoteImage.run(Request.get("neirongjianjie")));
        
        post.setId(Request.getInt("id"));
                service.update(post);
        int charuid = post.getId().intValue();
        
        if(Request.getInt("updtself") == 1){
            return showSuccess("保存成功" , "tuxiangxinxi_updtself.do");
        }
        return showSuccess("保存成功" , Request.get("referer"));
    }
    /**
     *  后台详情
     */
    @RequestMapping("/tuxiangxinxi_detail")
    public String detail()
    {
        int id = Request.getInt("id");
        Tuxiangxinxi map = service.find(id);
        request.setAttribute("map" , map);
        return "tuxiangxinxi_detail";
    }
    /**
     *  前台详情
     */
    @RequestMapping("/tuxiangxinxidetail")
    public String detailweb()
    {
        int id = Request.getInt("id");
        Tuxiangxinxi map = service.find(id);
        Query.execute("UPDATE tuxiangxinxi SET dianjishuai=dianjishuai+1 WHERE id="+request.getParameter("id")+"");



        int page = Math.max(Request.getInt("page"),1);
        Example example = new Example(Tuxiangxinxi.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andCondition("biao='tuxiangxinxi' AND wenzhangid='"+id+"'");

        List<Pinglun> pinglun = pinglunService.selectPageExample(example,page,15);
        assign("pinglunList" , pinglun);
        request.setAttribute("map" , map);
        return "tuxiangxinxidetail";
    }
        @RequestMapping("/tuxiangxinxi_batch")
    public String batch()
    {
        if(request.getParameter("delete")!=null)
        {
            String[] ids = request.getParameterValues("ids");
            if(ids!=null) Query.make("tuxiangxinxi").where("id" , "in" , ids).delete();
        }
        return showSuccess("批量处理成功",request.getHeader("referer"));
    }

        /**
    *  删除
    */
    @RequestMapping("/tuxiangxinxi_delete")
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
