package com.blog.service;

import com.blog.dao.CategoryDao;
import com.blog.po.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * Created by geekgao on 15-10-18.
 */
@Service
public class CategoryServiceImp implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public String getName(int id) throws IOException {
        return categoryDao.getName(id);
    }

    @Override
    public List<Category> getAll() throws IOException {
        return categoryDao.getAll();
    }

    @Override
    public int getArticleCountByCategoryId(int categoryId) throws IOException {
        return categoryDao.getArticleCountByCategoryId(categoryId);
    }

    @Override
    public boolean exist(String name) throws IOException {
        return categoryDao.exist(name);
    }

    @Override
    public void insert(Category category) throws IOException {
        categoryDao.insert(category);
    }

    @Override
    public void delete(String id) throws IOException {
        categoryDao.delete(id);
    }

    @Override
    public int getLatestId() throws IOException {
        return categoryDao.getLatestId();
    }

    @Override
    public void update(String id, String newName) throws IOException {
        categoryDao.update(id,newName);
    }
}
