package com.blog.mapper;

import com.blog.po.Comment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by panlu on 15-10-21.
 */
public interface CommentMapper {

    //插入对文章的回复
    @Insert("insert into comment values(null,#{user_name},#{user_email},#{time},#{content},#{type},#{article_id},null)")
    void insertArt(Comment commentObj);

    //插入对评论的回复
    @Insert("insert into comment values(null,#{user_name},#{user_email},#{time},#{content},#{type},#{article_id},#{comment_id})")
    void insertCom(Comment commentPojo);

    @Select("select * from comment where type = 'a' and comment_id is NULL and article_id = #{article_id} order by id DESC")
    List<Comment> selectCom(int article_id);

    @Select("select * from comment where type = 'c' and article_id=#{article} order by id DESC")
    List<Comment> selectRep(int article_id);

    //查询所有的评论(不包括回复呦)
    @Select("select * from comment where comment_id is NULL order by id DESC")
    List<Comment> selectAllCom();

    @Delete("delete from comment where id=#{id}")
    void deleteCom(int id);

    @Delete("delete from comment where comment_id = #{id}")
    void deleteReply(int id);

    @Delete("delete from comment where id = #{id}")
    void delete(int id);

    //查询评论表里共有多少条记录
    @Select("select count(id) from comment where comment_id is NULL")
    int getCommentRow();

    //查询评论表里某一部分的记录
    @Select("select * from comment where comment_id is NULL order by id DESC limit #{offset},#{size}")
    List<Comment> getPageComment(@Param("offset") int offset,@Param("size") int size);

}
