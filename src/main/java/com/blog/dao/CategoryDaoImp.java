package com.blog.dao;

import com.blog.mapper.CategoryMapper;
import com.blog.po.Category;
import com.blog.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

/**
 * Created by geekgao on 15-10-18.
 */
@Repository
public class CategoryDaoImp implements CategoryDao {

    @Override
    public String getName(int id) throws IOException {
        SqlSession session = MybatisUtils.getSession();
        try {
            CategoryMapper mapper = session.getMapper(CategoryMapper.class);
            return mapper.getName(id);
        } finally {
            session.close();
        }
    }

    @Override
    public List<Category> getAll() throws IOException {
        SqlSession session = MybatisUtils.getSession();
        try {
            CategoryMapper mapper = session.getMapper(CategoryMapper.class);
            return mapper.getAll();
        } finally {
            session.close();
        }
    }

    @Override
    public int getArticleCountByCategoryId(int categoryId) throws IOException {
        SqlSession session = MybatisUtils.getSession();
        try {
            CategoryMapper mapper = session.getMapper(CategoryMapper.class);
            return mapper.getArticleCountByCategoryId(categoryId);
        } finally {
            session.close();
        }
    }

    @Override
    public boolean exist(String name) throws IOException {
        SqlSession session = MybatisUtils.getSession();
        try {
            CategoryMapper mapper = session.getMapper(CategoryMapper.class);
            if (mapper.categoryCount(name) == 0) {
                return false;
            } else {
                return true;
            }
        } finally {
            session.close();
        }
    }

    @Override
    public void insert(Category category) throws IOException {
        SqlSession session = MybatisUtils.getSession();
        try {
            CategoryMapper mapper = session.getMapper(CategoryMapper.class);
            mapper.insert(category);
            session.commit();
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(String id) throws IOException {
        SqlSession session = MybatisUtils.getSession();
        try {
            CategoryMapper mapper = session.getMapper(CategoryMapper.class);
            mapper.delete(id);
            session.commit();
        } finally {
            session.close();
        }
    }

    @Override
    public int getLatestId() throws IOException {
        SqlSession session = MybatisUtils.getSession();
        try {
            CategoryMapper mapper = session.getMapper(CategoryMapper.class);
            return mapper.getLatestId();
        } finally {
            session.close();
        }
    }

    @Override
    public void update(String id, String newName) throws IOException {
        SqlSession session = MybatisUtils.getSession();
        try {
            CategoryMapper mapper = session.getMapper(CategoryMapper.class);
            mapper.update(id,newName);
            session.commit();
        } finally {
            session.close();
        }
    }
}
