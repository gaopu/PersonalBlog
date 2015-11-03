package com.blog.mapper;

import com.blog.po.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by geekgao on 15-10-12.
 */
public interface ArticleMapper {
    @Select("select * from article where id = #{id}")
    Article getArticle(int id);

    @Insert("insert into article values(null,#{author_Id},#{title},#{time},#{read_Num},#{comment_Num},#{deleted})")
    void insert(Article article);

    @Select("select max(id) from article")
    int getLatestId();

    //挑选出没有被删除的文章
    @Select("select * from article where deleted = 'n'")
    List<Article> getCommonArticle();

    //挑选出被删除的文章
    @Select("select * from article where deleted = 'y'")
    List<Article> getDeletedArticle();

    @Select("select read_num from article where id=#{articleId}")
    int getReadNum(int articleId);

    @Select("select comment_num from article where id=#{articleId}")
    int getCommentNum(int articleId);
}
