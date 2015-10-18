package com.blog.service;

import com.blog.dao.AdminDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by geekgao on 15-10-7.
 */
@Service
public class AdminServiceImp implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Override
    public boolean isCorrect(String email,String passwd) throws IOException {
        return passwd.equals(adminDao.getPasswd(email));
    }

    @Override
    public String getNickName(String email) throws IOException {
        return adminDao.getNickName(email);
    }

    @Override
    public int getId(String email) throws IOException {
        return adminDao.getId(email);
    }

    @Override
    public String getPasswd(String email) throws IOException {
        return adminDao.getPasswd(email);
    }
}
