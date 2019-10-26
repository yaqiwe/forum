package com.example.forum.mapper;

import com.example.forum.entity.comments;
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
 * @date ：Created in 2019/10/26 15:03
 * @description：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class commentsMapperTest {

    @Autowired
    commentsMapper commentsM;

    @Test //发布评论
    @Transactional
    void addComment() {
        comments com=new comments();
        com.setComText("评论1");
        com.setCreator(7);
        com.setComType(1);
        com.setQuestionId(40);
        int i = commentsM.addComment(com);
        Assert.assertEquals(1,i);
    }

    @Test //回复评论
    @Transactional
    void  addReply(){
        comments com=new comments();
        com.setComText("回复评论1");
        com.setCreator(7);
        com.setQuestionId(40);
        com.setComType(1);
        com.setReplyId(2);
        int i = commentsM.addComment(com);
        Assert.assertEquals(1,i);
    }

    @Test //查找一条评论
    void findByComId(){
        int id=2;
        comments com = commentsM.findByComId(id);
        Assert.assertEquals(com.getId(),id);
    }

    @Test//查找不存在的评论
    void findByComIdIsNull(){
        int id=0;
        comments com = commentsM.findByComId(id);
        Assert.assertNull(com);
    }
}