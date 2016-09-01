package com.blog.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by geekgao on 15-10-8.
 * 后台页面拦截器
 */
public class ManagePageInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String flag = (String) request.getSession().getAttribute("flag");
        if (flag != null && flag.equals("on")) {
            return true;
        }
        return false;
    }
}
