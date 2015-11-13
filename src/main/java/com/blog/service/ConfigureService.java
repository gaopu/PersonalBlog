package com.blog.service;

import com.blog.po.Configure;

import java.io.IOException;

/**
 * Created by hexing on 15-11-3.
 */
//博客配置功能
public interface ConfigureService {
    //获得博客配置
    public Configure getConfigured() throws IOException;
    //设置博客配置
    public void setConfigure(Configure configure) throws IOException;

}
