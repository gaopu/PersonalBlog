package com.blog.mapper;

import com.blog.po.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * Created by geekgao on 15-10-12.
 */
public interface ArticleMapper {
    @Select("select * from article where id = #{id}")
    Article getArticle(int id);

    @Insert("insert into article values(null,#{authorId},#{title},#{time},#{readNum},#{commentNum},#{deleted})")
    void insert(Article article);

    @Select("select max(id) from article")
    int getLatestId();
}
