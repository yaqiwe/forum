package com.example.forum.service;

import com.example.forum.entity.user;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/10/25 19:49
 * @description：用户操作
 */
@Validated
public interface userService {

    /**
     * 获取当前登录人的id
     * @return
     */
    public user getUser();

    /**
     * 根据用户Id查询用户信息
     * @param userId
     * @Exception forumException(forumEnums.USER_IS_NULL)
     * @return
     */
    public user getUserById(@NotNull(message = "查询的用户Id不能为空") int userId);
}
