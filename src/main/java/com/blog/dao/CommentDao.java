package com.blog.dao;

import com.blog.po.Comment;

import java.io.IOException;
import java.util.List;

/**
 * Created by panlu on 15-10-21.
 */
public interface CommentDao {

    /**
     * 获取一篇文章下的所有评论
     */
    void insertArt(Comment comm) throws IOException;

    void insertCom(Comment comm) throws IOException;

    List<Comment> selectCom(int article_id) throws IOException;

    List<Comment> selectRep(int article_id) throws IOException;

}
