package com.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by geekgao on 15-10-7.
 */
@Controller
public class ErrorController {
    @RequestMapping(value = "loginError" , method = RequestMethod.GET)
    public String loginError() {
        return "loginError";
    }
}
