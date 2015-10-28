package com.blog.mapper;

import com.blog.po.Comment;
import org.apache.ibatis.annotations.Insert;
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

    @Select("select * from comment where comment_id is NULL and article_id = #{article_id}")
    List<Comment> selectCom(int article_id);

    @Select("select * from comment where article_id=#{article}")
    List<Comment> selectRep(int article_id);
}
