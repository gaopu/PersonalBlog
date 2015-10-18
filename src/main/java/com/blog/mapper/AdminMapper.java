package com.blog.mapper;

import com.blog.po.Admin;
import com.blog.po.Article;
import org.apache.ibatis.annotations.Select;

/**
 * Created by geekgao on 15-10-7.
 */
public interface AdminMapper {
    @Select("select * from admin where email = #{email}")
    Admin getAdmin(String email);
}
