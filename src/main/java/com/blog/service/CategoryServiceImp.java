package com.blog.service;

import com.blog.mapper.CategoryMapper;
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
    private CategoryMapper categoryMapper;

    @Override
    public String getName(int id) throws IOException {
        return categoryMapper.getName(id);
    }

    @Override
    public List<Category> getAll() throws IOException {
        return categoryMapper.getAll();
    }

    @Override
    public int getArticleCountByCategoryId(int categoryId) throws IOException {
        return categoryMapper.getArticleCountByCategoryId(categoryId);
    }

    @Override
    public boolean exist(String name) throws IOException {
        return categoryMapper.categoryCount(name) != 0;
    }

    @Override
    public void insert(Category category) throws IOException {
        categoryMapper.insert(category);
    }

    @Override
    public void delete(String id) throws IOException {
        categoryMapper.delete(id);
    }

    @Override
    public int getLatestId() throws IOException {
        return categoryMapper.getLatestId();
    }

    @Override
    public void update(String id, String newName) throws IOException {
        categoryMapper.update(id,newName);
    }

    @Override
    public List<Integer> getCategoryByArticleId(int id) throws IOException {
        return categoryMapper.getCategoryByArticleId(id);
    }

    @Override
    public List<String> getAllCategory() throws IOException {
        return categoryMapper.getAllCategory();
    }

}
