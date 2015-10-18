package com.blog.dao;

import com.blog.po.ArticleCategory;

import java.io.IOException;

/**
 * Created by geekgao on 15-10-18.
 */
public interface ArticleCategoryDao {
    void insert(ArticleCategory articleCategory) throws IOException;
}
