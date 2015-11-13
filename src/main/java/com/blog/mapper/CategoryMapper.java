package com.blog.mapper;

import com.blog.po.Category;
import org.apache.ibatis.annotations.*;

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

    //获取文章分类
    @Select("select id from category where id in(select category_id from article_category where article_id=#{id})")
    public List<Integer> getCategoryByArticleId(int id);
    //获得全部分类
    @Select("select name from category")
    public List<String> getAllCategory();
    //删除文章分类
    @Delete("delete from article_category where article_id = #{id}")
    public void delCategory(int id);
    //设置新的文章分类
    @Insert("insert into article_category(article_id,category_id) values(#{id},#{selectedId})")
    public void setCategory(@Param("id") int id, @Param("selectedId") int selectedId);
}
