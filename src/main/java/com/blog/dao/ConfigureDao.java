package com.blog.dao;

import com.blog.po.Configure;

import java.io.IOException;

/**
 * Created by hexing on 15-11-3.
 */
//博客配置
public interface ConfigureDao {
    public Configure getConfigured() throws IOException;
    public void setConfigure(Configure configure) throws IOException;
}
