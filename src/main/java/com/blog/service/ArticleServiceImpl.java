package com.blog.service;

import com.blog.dao.ArticleCategoryDao;
import com.blog.dao.ArticleDao;
import com.blog.po.Article;
import com.blog.po.ArticleCategory;
import com.blog.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
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
    @Autowired
    private ArticleCategoryDao articleCategoryDao;

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
    public boolean isDeleted(int id) throws IOException {
        return articleDao.isDeleted(id);
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

    @Override
    public List<Article> getDeletedArticle() throws IOException {
        return articleDao.getDeletedArticle();
    }

    @Override
    public void movaToDusbin(int articleId) throws IOException {
        articleDao.movaToDusbin(articleId);
    }

    @Override
    public void delete(int articleId) throws IOException {
        articleCategoryDao.delete(articleId);
        articleDao.delete(articleId);
    }

    @Override
    public void recover(int articleId) throws IOException {
        articleDao.recover(articleId);
    }
}
