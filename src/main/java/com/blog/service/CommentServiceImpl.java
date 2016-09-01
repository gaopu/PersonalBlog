package com.blog.service;

import com.blog.dao.CommentDao;
import com.blog.po.Comment;
import com.blog.utils.PageParam;
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

    @Override
    public List<Comment> selectAllCom() {
        List<Comment> allCom = null;
        try {
            allCom = commentDao.selectAllCom();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return allCom;
    }

    @Override
    public void deleteCom(int id) throws IOException{
        try {
            commentDao.deleteCom(id);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteReply(int id) throws IOException {
        try {
            commentDao.deleteReply(id);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public int getCommentRow() throws IOException {
        int row = 0;
        try {
            row = commentDao.getCommentRow();
        }catch (IOException e){
            e.printStackTrace();
        }
        return row;
    }

    //分页时，获取一页的文章,一页的文章就是一个PageParam的对象
    @Override
    public PageParam pageOfComment(PageParam pageparam) throws IOException {
        int curpage = pageparam.getCurrPage();
        int offset = (curpage - 1) * PageParam.pageSize;
        int size = PageParam.pageSize;
        List<Comment> onepagecomment = commentDao.getPageComment(offset,size);
        pageparam.setDatacom(onepagecomment);
        return pageparam;
    }
}
