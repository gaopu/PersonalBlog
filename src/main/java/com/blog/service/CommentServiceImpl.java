package com.blog.service;

import com.blog.dao.CommentDao;
import com.blog.po.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * Created by panlu on 15-10-21.
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;


    @Override
    public void insertArt(Comment comm) throws IOException {
        commentDao.insertArt(comm);
    }

    @Override
    public void insertCom(Comment commPojo) throws IOException {
        commentDao.insertCom(commPojo);
    }

    @Override
    public List<Comment> selectCom(int article_id) throws IOException {
        List<Comment> tempCom = commentDao.selectCom(article_id);
        return tempCom;
    }

    @Override
    public List<Comment> selectRep(int article_id) throws IOException {
        List<Comment> tempCom = commentDao.selectRep(article_id);
        return tempCom;
    }
}
