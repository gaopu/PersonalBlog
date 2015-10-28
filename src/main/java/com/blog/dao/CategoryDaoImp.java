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

    /*private Category category;

    private Category getCategory(int id) throws IOException {
        SqlSession session = MybatisUtils.getSession();
        try {
            CategoryMapper mapper = session.getMapper(CategoryMapper.class);
            return mapper.getCategory(id);
        } finally {
            session.close();
        }
    }*/

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
}
