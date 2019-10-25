package com.example.forum.service.impl;

import com.example.forum.entity.user;
import com.example.forum.service.userService;
import org.springframework.stereotype.Service;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/10/25 19:56
 * @description：用户操作的实现
 */
@Service
public class userServiceImpl implements userService {

    @Override
    public user getUser() {
        /*未实现，引入shiro后在*/
        user us = new user();
        us.setId(7);
        return us;
    }
}
