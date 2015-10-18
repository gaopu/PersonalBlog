package com.blog.mapper;

import com.blog.po.ArticleCategory;
import org.apache.ibatis.annotations.Insert;

/**
 * Created by geekgao on 15-10-18.
 */
public interface ArticleCategoryMapper {
    @Insert("insert into article_category values(#{articleId},#{categoryId})")
    void insert(ArticleCategory articleCategory);
}
