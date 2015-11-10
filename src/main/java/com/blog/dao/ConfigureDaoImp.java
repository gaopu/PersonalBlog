package com.blog.dao;

import com.blog.mapper.ConfigureMapper;
import com.blog.po.Configure;
import com.blog.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.io.IOException;

/**
 * Created by hexing on 15-11-3.
 */
@Repository
public class ConfigureDaoImp implements ConfigureDao{

    @Override
    public Configure getConfigured() throws IOException {
        SqlSession sqlSession = MybatisUtils.getSession();
        try {
            ConfigureMapper configureMapper = sqlSession.getMapper(ConfigureMapper.class);
            Configure configured = configureMapper.getConfigured();
            sqlSession.commit();
            return configured;
        }finally {
            sqlSession.close();
        }

    }

    @Override
    public void setConfigure(Configure configure) throws IOException {
        SqlSession sqlSession = MybatisUtils.getSession();
        try {
            ConfigureMapper configureMapper = sqlSession.getMapper(ConfigureMapper.class);
            configureMapper.setConfigure(configure);
        }finally {
            sqlSession.close();
        }
    }
}
