package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import util.Uploader;
@Controller
public class UploadController extends BaseController{

    @RequestMapping("/upload")
    public String Upload() throws Exception
    {
        String path = request.getContextPath();
        Uploader uploader = new Uploader(request);
        uploader.setMaxSize(100 * 1024);
        String saveurl = "upload";
        uploader.setSavePath(saveurl);
        try{
            uploader.upload();
            String url = uploader.getUrl();
            request.setAttribute("url",url);
            return "upload";
        }catch (Exception e){
            return showError(e.getMessage());
        }
    }
}
