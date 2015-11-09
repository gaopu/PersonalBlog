package com.blog.service;

import com.blog.dao.ArticleCategoryDao;
import com.blog.dao.ArticleDao;
import com.blog.po.Article;
import com.blog.utils.PageParam;
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
    public void moveToDusbin(int articleId) throws IOException {
        articleDao.moveToDusbin(articleId);
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

    @Override
    public int getRowCount() throws IOException {
        return articleDao.getRowCount();
    }

    @Override
    public PageParam getPagedArticle(PageParam pageParam) throws IOException {
        int currPage = pageParam.getCurrPage();
        // limit offset, size
        int offset = (currPage - 1) * PageParam.pageSize;
        int size = PageParam.pageSize;
        List<Article> articleList = articleDao.getPagedArticle(offset,size);
        pageParam.setData(articleList);

        return pageParam;
    }
}
