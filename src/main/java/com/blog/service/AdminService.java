package com.blog.service;

import com.blog.dao.AdminDao;
import com.blog.po.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * Created by geekgao on 15-10-7.
 */
@Service
public class AdminService {

    @Autowired
    private AdminDao adminDao;
    //判断帐号和密码是否正确
    public boolean isCorrect(String email,String passwd) throws IOException {
        //从数据库根据邮箱帐号取出管理员帐号信息
        Admin admin = adminDao.selectAdmin(email);
        if (admin != null && admin.getPasswd().equals(passwd)) {
            return true;
        }
        return false;
    }

    public String getNickName(String email) throws IOException {
        //从数据库根据邮箱帐号取出管理员帐号信息
        Admin admin = adminDao.selectAdmin(email);
        if (admin != null) {
            return admin.getNickName();
        }
        return null;
    }
}
