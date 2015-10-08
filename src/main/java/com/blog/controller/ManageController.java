package com.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by geekgao on 15-10-7.
 * 后台管理页面控制器
 */
@Controller
@RequestMapping("manage")
public class ManageController {
    @RequestMapping(value = "" , method = RequestMethod.GET)
    public String manageHomePage() {
        return "manage/home";
    }

    @RequestMapping(value = "article" , method = RequestMethod.GET)
    public String articleManage() {
        return "manage/postlist";
    }
}
