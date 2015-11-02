package com.blog.mapper;

import com.blog.po.ArticleCategory;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

/**
 * Created by geekgao on 15-10-18.
 */
public interface ArticleCategoryMapper {
    @Insert("insert into article_category values(#{article_Id},#{category_Id})")
    void insert(ArticleCategory articleCategory);

    @Update("update article_category set category_id=#{param2} where category_id=#{param1}")
    void updateAfterDelCatrgory(String oldCategoryId, String newCategoryId);
}
