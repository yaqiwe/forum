package com.example.forum.service.impl;

import com.example.forum.Exceptions.forumException;
import com.example.forum.entity.comments;
import com.example.forum.enums.forumEnums;
import com.example.forum.mapper.commentsMapper;
import com.example.forum.service.commentsService;
import com.example.forum.service.questionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/10/26 15:27
 * @description：
 */
@Service
public class commentsServiceImpl implements commentsService {

    @Autowired
    commentsMapper commentsM;
    @Autowired
    questionService questionS;

    @Override
    public int addComment(comments com) {
        //查看是否存在该问题
        questionS.getQuestion(com.getQuestionId());
        //1.查看评论类型，若评论类型为1，
        if(com.getComType()==1){
            //2.查找回复的评论，若找不到抛出异常
            comments RepCom = findByComId(com.getReplyId());
            //3.回复的评论应该和评论属于同一篇文章,否则抛出异常
            if(RepCom.getQuestionId()!=com.getQuestionId())
                throw new forumException(forumEnums.REPLY_IS_ERROR);
        }
        //4.存入数据库
        return commentsM.addComment(com);
    }

    @Override
    public comments findByComId(int comId) {
        comments com = commentsM.findByComId(comId);
        if(com==null){
            throw new forumException(forumEnums.COMMENTS_IS_NULL);
        }
        return com;
    }


}
