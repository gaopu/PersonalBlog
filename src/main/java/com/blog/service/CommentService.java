package com.blog.service;

import com.blog.po.Comment;

import java.io.IOException;
import java.util.List;

/**
 * Created by panlu on 15-10-21.
 */
public interface CommentService {

    void insertArt(Comment comm) throws IOException;

    void insertCom(Comment comm) throws IOException;

    List<Comment> selectCom(int article_id) throws IOException;

    List<Comment> selectRep(int article_id) throws IOException;

}
