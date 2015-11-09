package com.blog.mapper;

import com.blog.po.Article;
import org.apache.ibatis.annotations.*;

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

    @Update("update article set deleted='y' where id=#{articleId}")
    void moveToDusbin(int articleId);

    @Delete("delete from article where id=#{articleId}")
    void delete(int articleId);

    @Update("update article set deleted='n' where id=#{articleId}")
    void recover(int articleId);
    //获取总记录数
    @Select("select count(*) from article WHERE deleted = 'n'")
    public int getRowCount();
    //获取文章
    @Select("select * from article where deleted = 'n' limit #{offset}, #{size}")
    public List<Article> getPagedArticle(@Param("offset") int offset, @Param("size") int size);

}
