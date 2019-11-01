package com.example.forum.service;

import com.example.forum.entity.user;
import com.example.forum.enums.forumEnums;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/10/26 16:04
 * @description：查找用户方法测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class getUserByIdTest {

    @Autowired
    userService userS;

    int userId=7;
    @Test
    void getUserById() {
        user us = userS.getUserById(userId);
        Assert.assertEquals(us.getId(),userId);
    }

    @Test
    void UserIsNull(){
        try {
            userS.getUserById(10000);
        } catch (Exception e) {
            Assert.assertEquals(e.getMessage(), forumEnums.USER_IS_NULL.getMsg());
        }
    }
}