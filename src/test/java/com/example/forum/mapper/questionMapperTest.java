package com.example.forum.mapper;

import com.example.forum.entity.question;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/10/25 14:34
 * @description：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
class questionMapperTest {

    @Autowired
    questionMapper questionM;
    @Test
    void findById() {
        int id=10;
        question que = questionM.findById(id);
        log.info("[questionMapperTest] findById:{}",que);
        Assert.assertEquals(que.getId(),id);
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
}