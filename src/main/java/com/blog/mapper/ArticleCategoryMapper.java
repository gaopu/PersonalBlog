package com.blog.mapper;

import com.blog.po.ArticleCategory;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by geekgao on 15-10-18.
 */
public interface ArticleCategoryMapper {
    @Insert("insert into article_category values(#{article_Id},#{category_Id})")
    void insert(ArticleCategory articleCategory);

    @Update("update article_category set category_id=#{param2} where category_id=#{param1}")
    void updateAfterDelCatrgory(String oldCategoryId, String newCategoryId);

    @Select("select category_id from article_category where article_id=#{articleId}")
    List<Integer> getCategoryId(int articleId);

    @Delete("delete from article_category where article_id=#{articleId}")
    void delete(int articleId);
}
