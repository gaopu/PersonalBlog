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
public class AdminDaoImp implements AdminDao {

    private Admin admin;

    public Admin getAdmin(String email) throws IOException {
        SqlSession session = MybatisUtils.getSession();
        try {
            AdminMapper mapper = session.getMapper(AdminMapper.class);
            admin = mapper.getAdmin(email);
        } finally {
            session.close();
        }
        return admin;
    }

    public Admin getAdmin(int id) throws IOException {
        SqlSession session = MybatisUtils.getSession();
        try {
            AdminMapper mapper = session.getMapper(AdminMapper.class);
            admin = mapper.getAdminById(id);
        } finally {
            session.close();
        }
        return admin;
    }

    public String getNickName(String email) throws IOException {
        //从数据库根据邮箱帐号取出管理员帐号信息
        admin = getAdmin(email);
        if (admin != null) {
            return admin.getNickName();
        }
        return null;
    }

    public int getId(String email) throws IOException {
        //从数据库根据邮箱帐号取出管理员帐号信息
        admin = getAdmin(email);
        if (admin != null) {
            return admin.getId();
        }
        return 0;
    }

    public String getPasswd(String email) throws IOException {
        //从数据库根据邮箱帐号取出管理员帐号信息
        admin = getAdmin(email);
        if (admin != null) {
            return admin.getPasswd();
        }
        return null;
    }

    @Override
    public String getNickName(int id) throws IOException {
        //从数据库根据邮箱帐号取出管理员帐号信息
        admin = getAdmin(id);
        if (admin != null) {
            return admin.getNickName();
        }
        return null;
    }
}
