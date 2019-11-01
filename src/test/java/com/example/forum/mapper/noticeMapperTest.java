package com.example.forum.mapper;

import com.example.forum.entity.notice;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/10/31 15:11
 * @description：
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class noticeMapperTest {
    @Autowired
    noticeMapper noticeM;

    notice no;

    public noticeMapperTest() {
        no=new notice();
        no.setQuestionTitle("关于mybatis");
        no.setQuestionId(40);
        no.setNoticeUser(7);
        no.setUserName("yaqiwe");
    }

    @Test
    void addNotice() {
        int i = noticeM.addNotice(no);
        Assert.assertEquals(1,i);
    }
}