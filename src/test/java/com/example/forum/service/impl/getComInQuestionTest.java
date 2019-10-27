package com.example.forum.service.impl;

import com.example.forum.dto.commentListDto;
import com.example.forum.service.commentsService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/10/27 10:54
 * @description：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class getComInQuestionTest {

    @Autowired
    commentsService commentsS;

    @Test
    void getComInQuestion() {
        List<commentListDto> comInQuestion = commentsS.getComInQuestion(40);
    }
}