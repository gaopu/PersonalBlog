package com.blog.mapper;

import com.blog.po.Category;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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

    @Select("select count(article_id) from article_category where category_id=#{categoryId}")
    int getArticleCountByCategoryId(int categoryId);

    /**
     * 返回按名称找到的类型个数
     * @param name 类型名
     * @return
     */
    @Select("select count(id) from category where name=#{name}")
    int categoryCount(String name);

    @Insert("insert into category values(null,#{name})")
    void insert(Category category);

    @Delete("delete from category where id=#{id}")
    void delete(String id);

    @Select("select max(id) from category")
    int getLatestId();

    @Update("update category set name=#{param2} where id=#{param1}")
    void update(String id, String newName);
}
