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
        System.out.println("CommentService.insertArt()方法执行,评论成功保存");
    }

    @Override
    public void insertCom(Comment commPojo) throws IOException {

        commentDao.insertCom(commPojo);
        System.out.println("CommentService.insertCom()方法执行,回复成功保存");
    }

    @Override
    public List<Comment> selectCom(int article_id) throws IOException {

        List<Comment> tempCom = commentDao.selectCom(article_id);
        for (Comment t:tempCom){
            System.out.println(t.getContent());
            System.out.println(t.getTime());
        }
        System.out.println("CommentService.selectCom()方法执行,数据查询成功");
        return tempCom;
    }

    @Override
    public List<Comment> selectRep(int article_id) throws IOException {

        List<Comment> tempCom = commentDao.selectRep(article_id);
        for (Comment t:tempCom){
            System.out.println(t.getContent());
            System.out.println(t.getUser_name());
            System.out.println(t.getTime());
        }
        System.out.println("CommentService.selectRep()方法执行,数据查询成功");
        return tempCom;
    }
}
