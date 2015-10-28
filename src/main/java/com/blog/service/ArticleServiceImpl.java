package com.blog.service;

import com.blog.dao.ArticleDao;
import com.blog.po.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by geekgao on 15-10-12.
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleDao articleDao;

    @Override
    public int getAuthorId(int id) throws IOException {
        return articleDao.getAuthorId(id);
    }

    @Override
    public String getTitle(int id) throws IOException {
        return articleDao.getTitle(id);
    }

    @Override
    public Date getTime(int id) throws IOException {
        return articleDao.getTime(id);
    }

    @Override
    public int getReadNum(int id) throws IOException {
        return articleDao.getReadNum(id);
    }

    @Override
    public int getCommentNum(int id) throws IOException {
        return articleDao.getCommentNum(id);
    }

    @Override
    public String getDeleted(int id) throws IOException {
        return articleDao.getDeleted(id);
    }

    @Override
    public void insert(Article article) throws IOException {
        articleDao.insert(article);
    }

    @Override
    public int getLatestId() throws IOException {
        return articleDao.getLatestId();
    }

    @Override
    public List<Article> getCommonArticle() throws IOException {
        return articleDao.getCommonArticle();
    }
}
