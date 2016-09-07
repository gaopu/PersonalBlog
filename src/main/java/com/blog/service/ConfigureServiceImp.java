package com.blog.service;

import com.blog.mapper.ConfigureMapper;
import com.blog.po.Configure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by hexing on 15-11-3.
 */
@Service
public class ConfigureServiceImp implements ConfigureService{
    @Autowired
    private ConfigureMapper configureMapper;

    public Configure getConfigured() throws IOException {
        return configureMapper.getConfigured();
    }
    public void setConfigure(HttpServletRequest request,Configure configure) throws IOException {
        configureMapper.setConfigure(configure);
        //确保导航栏显示的博客名称一直是最新的
        request.getServletContext().setAttribute("blogName",configure.getHead());
    }
}
