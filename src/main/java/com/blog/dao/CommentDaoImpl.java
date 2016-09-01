package com.blog.dao;

import com.blog.mapper.CommentMapper;
import com.blog.po.Comment;
import com.blog.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

/**
 * Created by panlu on 15-10-21.
 */
@Repository
public class CommentDaoImpl implements CommentDao {

    private Comment commentObj;   //comment的对象  不用自己new，spring自动new

    @Override
    public void insertArt(Comment commentObj) throws IOException {
        SqlSession session = MybatisUtils.getSession();
        try {
            CommentMapper mapper = session.getMapper(CommentMapper.class);
            mapper.insertArt(commentObj);  //使用自动注入的commentObj
            session.commit();
        }finally {
            session.close();
        }
    }

    @Override
    public void insertCom(Comment commPojo) throws IOException {
        SqlSession session = MybatisUtils.getSession();
        try {
            CommentMapper mapper = session.getMapper(CommentMapper.class);
            mapper.insertCom(commPojo);  //使用自动注入的commentObj
            session.commit();
        }finally {
            session.close();
        }
    }

    @Override
    public List<Comment> selectCom(int article_id) throws IOException {
        List<Comment> commentList;
        SqlSession session = MybatisUtils.getSession();
        try {
            CommentMapper mapper = session.getMapper(CommentMapper.class);
            commentList = mapper.selectCom(article_id);
            session.commit();
        }finally {
            session.close();
        }
        return commentList;
    }

    @Override
    public List<Comment> selectRep(int article_id) throws IOException {
        List<Comment> replyList;
        SqlSession session = MybatisUtils.getSession();
        try {
            CommentMapper mapper = session.getMapper(CommentMapper.class);
            replyList = mapper.selectRep(article_id);
            session.commit();
        }finally {
            session.close();
        }
        return replyList;
    }

    @Override
    public List<Comment> selectAllCom() throws IOException {
        List<Comment> allCom;
        SqlSession session = MybatisUtils.getSession();
        try {
            CommentMapper mapper = session.getMapper(CommentMapper.class);
            allCom = mapper.selectAllCom();
            session.commit();
        }finally {
            session.close();
        }
        return allCom;
    }

    @Override
    public void deleteCom(int id) throws IOException {
        SqlSession session = MybatisUtils.getSession();
        try {
            CommentMapper mapper = session.getMapper(CommentMapper.class);
            mapper.deleteCom(id);
            session.commit();
        }finally {
            session.close();
        }
    }

    @Override
    public void deleteReply(int id) throws IOException {
        SqlSession session = MybatisUtils.getSession();
        try {
            CommentMapper mapper = session.getMapper(CommentMapper.class);
            mapper.deleteReply(id);
            session.commit();
        }finally {
            session.close();
        }
    }

    @Override
    public void delete(int id) throws IOException {
        SqlSession session = MybatisUtils.getSession();
        try {
            CommentMapper mapper = session.getMapper(CommentMapper.class);
            mapper.delete(id);
            session.commit();
        }finally {
            session.close();
        }
    }

    @Override
    public int getCommentRow() throws IOException{
        SqlSession session = MybatisUtils.getSession();
        int row = 0;
        try {
            CommentMapper mapper = session.getMapper(CommentMapper.class);
            row = mapper.getCommentRow();
            session.commit();
        }finally {
            session.close();
        }
        return row;
    }

    @Override
    public List<Comment> getPageComment(int offset, int size) throws IOException {
        SqlSession session = MybatisUtils.getSession();
        List<Comment> onePageOfAll = null;
        try {
            CommentMapper mapper = session.getMapper(CommentMapper.class);
            onePageOfAll = mapper.getPageComment(offset,size);
            session.commit();
        }finally {
            session.close();
        }
        return onePageOfAll;
    }
}
