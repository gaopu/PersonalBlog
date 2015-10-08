package com.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by geekgao on 2015/10/6.
 * 首页控制器
 */
@Controller
public class HomePageController {
    @RequestMapping(value = "" , method = RequestMethod.GET)
    public String getHomePage() {
        return "index";
    }
}
