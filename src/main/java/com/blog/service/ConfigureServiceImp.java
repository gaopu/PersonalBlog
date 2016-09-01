package com.blog.service;

import com.blog.dao.ConfigureDao;
import com.blog.po.Configure;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by hexing on 15-11-3.
 */
@Service
public class ConfigureServiceImp implements ConfigureService{
    @Resource
    ConfigureDao dao;

    public Configure getConfigured() throws IOException {
        return dao.getConfigured();
    }
    public void setConfigure(HttpServletRequest request,Configure configure) throws IOException {
        dao.setConfigure(configure);
        //确保导航栏显示的博客名称一直是最新的
        request.getServletContext().setAttribute("blogName",configure.getHead());
    }
}
