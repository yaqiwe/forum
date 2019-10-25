package com.example.forum.service;

import com.example.forum.entity.question;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/10/25 17:27
 * @description：发布问题的测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
class releaseTest {

    @Autowired
    questionService questionS;

    private String title="标题";
    private String text="问题详情";
    private int creator=11;
    private String tag="标签1,标签2,标签3";

    @Test
    @Transactional
    void releaseQuestion() {
        questionS.releaseQuestion(title,text,creator,tag);
    }

    @Test
    @Transactional
    void titleIsNull(){
        try {
            questionS.releaseQuestion(null,text,creator,tag);
        } catch (Exception e) {
            Assert.assertEquals(getValidationMessage(e),"[标题不能为空]");
        }
    }

    @Test
    @Transactional
    void textIsNull(){
        try {
            questionS.releaseQuestion(title,null,creator,tag);
        } catch (Exception e) {
            Assert.assertEquals(getValidationMessage(e),"[问题详情不能为空]");
        }
    }


    private String getValidationMessage(Exception e){
        if(e instanceof ConstraintViolationException){
            ConstraintViolationException cve= (ConstraintViolationException) e;
            List<String> defaultMsg = cve.getConstraintViolations()
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.toList());
            return defaultMsg.toString();
        }
        return null;
    }
}