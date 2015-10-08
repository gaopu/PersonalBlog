package com.blog.mapper;

import com.blog.po.Admin;
import org.apache.ibatis.annotations.Select;

/**
 * Created by geekgao on 15-10-7.
 */
public interface AdminMapper {
    @Select("select * from admin where email = #{email}")
    Admin selectAdmin(String email);
}
