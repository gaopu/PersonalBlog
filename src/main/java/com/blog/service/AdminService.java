package com.blog.service;

import java.io.IOException;

/**
 * Created by geekgao on 15-10-18.
 */
public interface AdminService {
    //判断帐号和密码是否正确
    boolean isCorrect(String email, String passwd) throws IOException;

    String getNickName(String email) throws IOException;

    String getNickName(int id) throws IOException;

    int getId(String email) throws IOException;

    String getPasswd(String email) throws IOException;
}
