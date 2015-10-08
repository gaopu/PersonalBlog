package com.blog.dao;

import com.blog.mapper.AdminMapper;
import com.blog.po.Admin;
import com.blog.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.io.IOException;

/**
 * Created by geekgao on 15-10-7.
 */
@Repository
public class AdminDao {
    public Admin selectAdmin(String email) throws IOException {
        SqlSession session = MybatisUtils.getSession();
        try {
            AdminMapper mapper = session.getMapper(AdminMapper.class);
            Admin admin = mapper.selectAdmin(email);
            return admin;
        } finally {
            session.close();
        }
    }
}
