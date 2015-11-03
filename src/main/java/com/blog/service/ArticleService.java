package com.blog.service;

import com.blog.po.Article;

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

    String getDeleted(int id) throws IOException;

    void insert(Article article) throws IOException;

    int getLatestId() throws IOException;

    List<Article> getCommonArticle() throws IOException;

    List<Article> getDeletedArticle() throws IOException;
}
