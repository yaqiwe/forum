package com.example.forum.service;

import com.example.forum.ConExceptionUtil;
import com.example.forum.dto.questionDto;
import com.github.pagehelper.Page;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/10/26 11:07
 * @description：
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class getQuestionListTest {

    @Autowired
    questionService questionS;

    private int limit=10;

    private int page=1;

    @Test
    void getQuestion() {
        Page<questionDto> que = questionS.getQuestionList(page, limit);
        Assert.assertEquals(que.getPageSize(),limit);
    }

    @Test
    void limitMinIs0(){
        try {
            Page<questionDto> que = questionS.getQuestionList(page, 0);
        } catch (Exception e) {
            Assert.assertEquals(ConExceptionUtil.getValidationMessage(e),"[每页数据条数最小值不能小于1]");
        }
    }

    @Test
    void pageMinIs0(){
        try {
            Page<questionDto> que = questionS.getQuestionList(0, limit);
        } catch (Exception e) {
            Assert.assertEquals(ConExceptionUtil.getValidationMessage(e),"[页数最小值不能小于1]");
        }
    }
}