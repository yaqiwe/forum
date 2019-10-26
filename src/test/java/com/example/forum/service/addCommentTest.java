package com.example.forum.service;

import com.example.forum.entity.comments;
import com.example.forum.enums.forumEnums;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/10/26 17:07
 * @description：评论操作相关测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class addCommentTest {
    @Autowired
    commentsService commentsS;


    private  comments getCom(){
        comments com;
        com=new comments();
        com.setCreator(7);
        com.setComText("评论测试");
        com.setQuestionId(40);
        return com;
    }

    @Test
    @Transactional  //发布评论
    void addComment(){
        int i = commentsS.addComment(getCom());
        Assert.assertEquals(i,1);
    }

    @Test //评论的文章不存在
    void QuesIsNull(){
        comments com=getCom();
        com.setQuestionId(0);
        try {
            commentsS.addComment(com);
        } catch (Exception e) {
            Assert.assertEquals(e.getMessage(), forumEnums.QUESTION_IS_NULL.getMsg());
        }
    }

    @Test//回复评论
    @Transactional
    void addReply(){
        comments com=getCom();
        com.setReplyId(2);
        com.setComType(1);
        int i = commentsS.addComment(com);
        Assert.assertEquals(i,1);
    }


    @Test
    @Transactional //回复的评论不存在
    void addRepal(){
        comments com=getCom();
        com.setReplyId(1);
        com.setComType(1);
        try {
            commentsS.addComment(com);
        } catch (Exception e) {
            Assert.assertEquals(e.getMessage(),forumEnums.COMMENTS_IS_NULL.getMsg());
        }
    }

    @Test
    @Transactional //回复的评论不存在
    void addRepal1(){
        comments com=getCom();
        com.setReplyId(2);
        com.setComType(1);
        com.setQuestionId(11);
        try {
            commentsS.addComment(com);
        } catch (Exception e) {
            Assert.assertEquals(e.getMessage(),forumEnums.REPLY_IS_ERROR.getMsg());
        }
    }

}