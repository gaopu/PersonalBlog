package com.blog.service;

import com.blog.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by geekgao on 15-10-7.
 */
@Service
public class AdminServiceImp implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public boolean isCorrect(String email,String passwd) throws IOException {
        return passwd.equals(adminMapper.getAdmin(email).getPasswd());
    }

    @Override
    public String getNickName(String email) throws IOException {
        return adminMapper.getAdmin(email).getNickName();
    }

    @Override
    public String getNickName(int id) throws IOException {
        return adminMapper.getAdminById(id).getNickName();
    }

    @Override
    public int getId(String email) throws IOException {
        return adminMapper.getAdmin(email).getId();
    }

    @Override
    public String getPasswd(String email) throws IOException {
        return adminMapper.getAdmin(email).getPasswd();
    }
}
