package com.blog.service;

import com.blog.po.Comment;
import com.blog.utils.PageParam;

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

    List<Comment> selectAllCom() throws IOException;

    void deleteCom(int id) throws IOException;

    void deleteReply(int id) throws IOException;

    int getCommentRow() throws IOException;

    //分页时，获取一页的文章
    PageParam pageOfComment(PageParam pageparam) throws IOException;
}
