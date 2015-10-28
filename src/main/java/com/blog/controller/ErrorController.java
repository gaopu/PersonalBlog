package com.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by geekgao on 15-10-7.
 */
@Controller
public class ErrorController {
    /**
     * 登录错误信息页面
     * @return
     */
    @RequestMapping(value = "loginError" , method = RequestMethod.GET)
    public String loginError() {
        return "loginError";
    }

    /**
     * 重复登录错误页面
     * @return
     */
    @RequestMapping(value = "reLogin" , method = RequestMethod.GET)
    public String reLoginError() {
        return "reLoginError";
    }
}
