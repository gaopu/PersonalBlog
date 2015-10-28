package com.blog.mapper;

import com.blog.po.Category;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by geekgao on 15-10-18.
 */
public interface CategoryMapper {
    @Select("select * from category where id = #{id}")
    Category getCategory(int id);

    @Select("select name from category where id = #{id}")
    String getName(int id);

    @Select("select * from category")
    List<Category> getAll();
}
