package com.blog.dao;

import com.blog.po.Admin;

import java.io.IOException;

/**
 * Created by geekgao on 15-10-18.
 */
public interface AdminDao {
    Admin getAdmin(String email) throws IOException;

    Admin getAdmin(int id) throws IOException;

    String getNickName(String email) throws IOException;

    int getId(String email) throws IOException;

    String getPasswd(String email) throws IOException;

    String getNickName(int id) throws IOException;
}
