package com.example.forum.service.impl;

import com.example.forum.Exceptions.forumException;
import com.example.forum.entity.user;
import com.example.forum.enums.forumEnums;
import com.example.forum.mapper.userMapper;
import com.example.forum.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/10/25 19:56
 * @description：用户操作的实现
 */
@Service
public class userServiceImpl implements userService {

    @Autowired
    userMapper userM;

    @Override
    public user getUser() {
        /*未实现，引入shiro后在*/
        user us = new user();
        us.setId(7);
        return us;
    }

    @Override
    public user getUserById(int userId) {
        user us = userM.findById(userId);
        if (us==null){
            throw new forumException(forumEnums.USER_IS_NULL);
        }
        return us;
    }
}
