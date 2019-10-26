package com.example.forum.mapper;

import com.example.forum.entity.user;
import org.apache.ibatis.annotations.Select;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/10/26 15:40
 * @description：
 */
public interface userMapper {

    @Select("select * from user where id=#{userId}")
    public user findById(int userId);
}
