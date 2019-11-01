package com.example.forum.service;

import com.example.forum.entity.question;
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
 * @date ：Created in 2019/10/26 15:54
 * @description：查找文章详情操作测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class getQuestionTest {

    @Autowired
    questionService questionS;

    int id=40;
    @Test
    void getQuestion() {
        question que = questionS.getQuestion(id);
        Assert.assertEquals(que.getId(),id);
    }

    @Test
    void getQueIsNull(){
        try {
            questionS.getQuestion(1000);
        } catch (Exception e) {
            Assert.assertEquals(e.getMessage(), forumEnums.QUESTION_IS_NULL.getMsg());
        }
    }
}