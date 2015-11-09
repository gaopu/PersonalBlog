package com.blog.service;

import com.blog.po.Article;
import com.blog.utils.PageParam;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by geekgao on 15-10-12.
 */
public interface ArticleService {

    int getAuthorId(int id) throws IOException;

    String getTitle(int id) throws IOException;

    Date getTime(int id) throws IOException;

    int getReadNum(int id) throws IOException;

    int getCommentNum(int id) throws IOException;

    boolean isDeleted(int id) throws IOException;

    void insert(Article article) throws IOException;

    int getLatestId() throws IOException;

    List<Article> getCommonArticle() throws IOException;

    List<Article> getDeletedArticle() throws IOException;

    void moveToDusbin(int articleId) throws IOException;

    void delete(int articleId) throws IOException;

    void recover(int articleId) throws IOException;

    //获取文章总记录数
    public int getRowCount() throws IOException;
    //分页获得配置的文章
    public PageParam getPagedArticle(PageParam pageParam) throws IOException;

}
