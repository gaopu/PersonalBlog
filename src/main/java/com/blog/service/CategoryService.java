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
}
