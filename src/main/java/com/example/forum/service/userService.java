package com.example.forum.service;

import com.example.forum.entity.user;
import org.springframework.validation.annotation.Validated;

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
}
