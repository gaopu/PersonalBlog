package com.blog.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
/**
 * Created by geekgao on 2015/10/5.
 */

public class MybatisUtils {

    private static SqlSessionFactory sessionFactory;

    public static SqlSession getSession() throws IOException {

        //没有sessionFactory实例时，先生成
        if (sessionFactory == null) {
            String resource = "mybatisConfig.xml";
            InputStream is;
            is = Resources.getResourceAsStream(resource);
            sessionFactory = new SqlSessionFactoryBuilder().build(is);
        }

        return sessionFactory.openSession();
    }
}
