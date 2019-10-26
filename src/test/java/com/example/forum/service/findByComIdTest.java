package com.example.forum.service;

import com.example.forum.entity.comments;
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
 * @date ：Created in 2019/10/26 16:40
 * @description：查找评论相关测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class findByComIdTest {
    @Autowired
    commentsService commentsS;

    int comId=2;

    @Test
    void findByComId(){
        comments com = commentsS.findByComId(comId);
        Assert.assertEquals(comId,com.getId());
    }

    @Test
    void ConIsNull(){
        try {
            commentsS.findByComId(10000);
        } catch (Exception e) {
            Assert.assertEquals(e.getMessage(), forumEnums.COMMENTS_IS_NULL.getMsg());
        }
    }

}