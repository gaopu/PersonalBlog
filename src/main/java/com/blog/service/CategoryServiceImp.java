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
}
