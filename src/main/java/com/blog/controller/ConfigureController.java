package com.blog.controller;

import com.blog.po.Configure;
import com.blog.service.ConfigureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by hexing on 15-10-15.
 */
@Controller
@RequestMapping("manage")
public class ConfigureController {
    @Autowired
    ConfigureService configureService;

    //获取文章配置
    @RequestMapping(value = "/configured",method = RequestMethod.GET)
    public String getConfigured(ModelMap map) throws IOException {
        Configure configured = configureService.getConfigured();
        map.addAttribute("configured",configured);
        return "manage/settings";
    }

    //设置文章配置
    @RequestMapping(value = "/setconfigure",method = RequestMethod.POST)
    public void setConfigure(HttpServletRequest request) throws IOException {
        Configure configure = new Configure();
        configure.setHead(request.getParameter("head"));
        configure.setDescrib(request.getParameter("describ"));
        configure.setEdit_type(Integer.parseInt(request.getParameter("editor")));
        configure.setDisplay_num(Integer.parseInt(request.getParameter("display")));
        configure.setEmail_inform(Integer.parseInt(request.getParameter("isemail")));
        configureService.setConfigure(request,configure);
    }
}
