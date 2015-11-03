package com.blog.dao;

import com.blog.mapper.ArticleCategoryMapper;
import com.blog.mapper.ArticleMapper;
import com.blog.po.ArticleCategory;
import com.blog.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.io.IOException;

/**
 * Created by geekgao on 15-10-18.
 */
@Repository
public class ArticleCategoryDaoImp implements ArticleCategoryDao {
    @Override
    public void insert(ArticleCategory articleCategory) throws IOException {
        SqlSession session = MybatisUtils.getSession();
        try {
            ArticleCategoryMapper mapper = session.getMapper(ArticleCategoryMapper.class);
            mapper.insert(articleCategory);
            session.commit();
        } finally {
            session.close();
        }
    }

    @Override
    public void updateAfterDelCatrgory(String oldCategoryId, String newCategoryId) throws IOException {
        SqlSession session = MybatisUtils.getSession();
        try {
            ArticleCategoryMapper mapper = session.getMapper(ArticleCategoryMapper.class);
            mapper.updateAfterDelCatrgory(oldCategoryId, newCategoryId);
            session.commit();
        } finally {
            session.close();
        }
    }

    @Override
    public int getCategoryId(int articleId) throws IOException {
        SqlSession session = MybatisUtils.getSession();
        try {
            ArticleCategoryMapper mapper = session.getMapper(ArticleCategoryMapper.class);
            return mapper.getCategoryId(articleId);
        } finally {
            session.close();
        }
    }
}
