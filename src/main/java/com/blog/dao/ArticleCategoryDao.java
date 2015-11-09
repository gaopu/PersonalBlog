package com.blog.dao;

import com.blog.po.ArticleCategory;

import java.io.IOException;
import java.util.List;

/**
 * Created by geekgao on 15-10-18.
 */
public interface ArticleCategoryDao {
    void insert(ArticleCategory articleCategory) throws IOException;

    /**
     * 当删除类别后设置旧的文章id为新的id
     * @param oldCategoryId
     * @param newCategoryId
     * @throws IOException
     */
    void updateAfterDelCatrgory(String oldCategoryId,String newCategoryId) throws IOException;

    List<Integer> getCategoryId(int articleId) throws IOException;

    void delete(int articleId) throws IOException;
}
