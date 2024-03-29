package com.example.forum.mapper;

import com.example.forum.dto.questionDto;
import com.example.forum.entity.question;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/10/25 14:34
 * @description：
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@Slf4j
class questionMapperTest {

    @Autowired
    questionMapper questionM;

    int questionId=40;
    @Test
    void findById() {
        question que = questionM.findById(questionId);
        log.info("[questionMapperTest] findById:{}",que);
        Assert.assertEquals(que.getId(),questionId);
    }

    @Test
    @Transactional
    void insertQue(){
        question que=new question();
        que.setTitle("标题");
        que.setCreator(11);
        que.setProblemDescribe("问题描述");
        int i = questionM.insertQue(que);
        Assert.assertEquals(1,i);
    }

    @Test
    void findAllTest(){
        int page=1;
        int limit=10;
        PageHelper.startPage(page,limit);
        Page<question> que = questionM.finAll();
        Assert.assertEquals(limit,que.getPageSize());
    }

    @Test
    void finAllByQuesAndUserTest(){
        int page=0;
        int limit=10;
        PageHelper.startPage(page,limit);
        Page<questionDto> dto = questionM.finAllByQuesAndUser();
        Assert.assertEquals(dto.getPageSize(),limit);
    }


    @Test
    void AddViewCountTest(){
        int i = questionM.addViewCount(questionId);
        Assert.assertEquals(i,1);
    }

    @Test
    void AddCommentCount(){
        int i = questionM.addCommentCount(questionId);
        Assert.assertEquals(i,1);
    }

    @Test
    void AddLikeCount(){
        int i = questionM.addLikeCount(questionId);
        Assert.assertEquals(i,1);
    }
}