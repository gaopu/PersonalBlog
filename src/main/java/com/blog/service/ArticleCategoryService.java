package com.blog.service;

import com.blog.po.ArticleCategory;

import java.io.IOException;
import java.util.List;

/**
 * Created by geekgao on 15-10-18.
 */
public interface ArticleCategoryService {
    void insert(ArticleCategory articleCategory) throws IOException;

    void updateAfterDelCatrgory(String oldCategoryId,String newCategoryId) throws IOException;

    List<Integer> getCategoryId(int articleId) throws IOException;
}
