package com.blog.service;

import com.blog.dao.ArticleCategoryDao;
import com.blog.po.ArticleCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by geekgao on 15-10-18.
 */
@Service
public class ArticleCategoryServiceImp implements ArticleCategoryService {

    @Autowired
    private ArticleCategoryDao articleCategoryDao;

    @Override
    public void insert(ArticleCategory articleCategory) throws IOException {
        articleCategoryDao.insert(articleCategory);
    }

    @Override
    public void updateAfterDelCatrgory(String oldCategoryId, String newCategoryId) throws IOException {
        articleCategoryDao.updateAfterDelCatrgory(oldCategoryId,newCategoryId);
    }

    @Override
    public int getCategoryId(int articleId) throws IOException {
        return articleCategoryDao.getCategoryId(articleId);
    }
}
