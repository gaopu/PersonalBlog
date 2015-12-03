package com.blog.service;

import com.blog.po.Category;

import java.io.IOException;
import java.util.List;

/**
 * Created by geekgao on 15-10-18.
 */
public interface CategoryService {
    /**
     * 返回id所对应的类别的名称
     * @param id
     * @return
     */

    String getName(int id) throws IOException;

    /**
     * 返回所有类别信息
     * @return
     */
    List<Category> getAll() throws IOException;

    /**
     * 获取某分类下的文章数量
     * @param categoryId 分类id
     * @return
     */
    int getArticleCountByCategoryId(int categoryId) throws IOException;

    /**
     * 检测类型是否存在
     * @param name 类型名
     * @return
     */
    boolean exist(String name) throws IOException;

    void insert(Category category) throws IOException;

    public void delete(String id) throws IOException;

    int getLatestId() throws IOException;

    void update(String id, String newName) throws IOException;

    //获得文章分类
    public List<Integer> getCategoryByArticleId(int id) throws IOException;
    //获得全部文章的分类
    public List<String> getAllCategory() throws IOException;

}
