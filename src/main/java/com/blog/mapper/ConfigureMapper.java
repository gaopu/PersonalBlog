package com.blog.mapper;

import com.blog.po.Configure;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * Created by hexing on 15-10-15.
 */
public interface ConfigureMapper {
    //获取配置信息
    @Select("select * from configure where id=1")
    Configure getConfigured();
    //设置配置信息
    @Update("update configure set head=#{head},describ=#{describ},edit_type=#{edit_type},display_num=#{display_num},email_inform=#{email_inform} where id=1")
    void setConfigure(Configure configure);
}
