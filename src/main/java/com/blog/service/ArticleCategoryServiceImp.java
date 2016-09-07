package com.blog.service;

import com.blog.mapper.ArticleCategoryMapper;
import com.blog.po.ArticleCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * Created by geekgao on 15-10-18.
 */
@Service
public class ArticleCategoryServiceImp implements ArticleCategoryService {

    @Autowired
    private ArticleCategoryMapper articleCategoryMapper;

    @Override
    public void insert(ArticleCategory articleCategory) throws IOException {
        articleCategoryMapper.insert(articleCategory);
    }

    @Override
    public void updateAfterDelCatrgory(String oldCategoryId, String newCategoryId) throws IOException {
        articleCategoryMapper.updateAfterDelCatrgory(oldCategoryId,newCategoryId);
    }

    @Override
    public List<Integer> getCategoryId(int articleId) throws IOException {
        return articleCategoryMapper.getCategoryId(articleId);
    }
}
