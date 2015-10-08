package com.blog.controller;

import com.blog.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by geekgao on 2015/10/6.
 * 管理员登录后台控制器
 */
@Controller
public class LoginController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "login" , method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "loginVerify" , method = RequestMethod.POST)
    public void verify(HttpSession session, HttpServletResponse response, @RequestParam("email") String email, @RequestParam("passwd") String passwd) throws IOException {
        //如果帐号信息正确,session中加入“已经等录，email帐号，昵称3条信息”
        if (adminService.isCorrect(email,passwd)) {
            //标记是否登录
            session.setAttribute("flag","on");
            session.setAttribute("email",email);
            session.setAttribute("nickname",adminService.getNickName(email));
            response.sendRedirect("manage");
            return;
        }
        response.sendRedirect("loginError");
    }

}
