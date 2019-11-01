package com.example.forum.service.impl;

import com.example.forum.Exceptions.forumException;
import com.example.forum.dto.commentListDto;
import com.example.forum.dto.commentsDto;
import com.example.forum.entity.comments;
import com.example.forum.entity.question;
import com.example.forum.enums.forumEnums;
import com.example.forum.mapper.commentsMapper;
import com.example.forum.service.commentsService;
import com.example.forum.service.noticeService;
import com.example.forum.service.questionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/10/26 15:27
 * @description：
 */
@Service
@Slf4j
public class commentsServiceImpl implements commentsService {

    @Autowired
    commentsMapper commentsM;
    @Autowired
    questionService questionS;

    @Override
    @Transactional
    public question addComment(comments com){
        //查看是否存在该问题,防止评论时该文章已经删除
        question que = questionS.getQuestion(com.getQuestionId());
        //1.查看评论类型，若评论类型为1，
        if (com.getComType() == 1) {
            //2.查找回复的评论，若找不到抛出异常
            comments RepCom = findByComId(com.getReplyId());
            //3.回复的评论应该和评论属于同一篇文章,否则抛出异常
            if (RepCom.getQuestionId() != com.getQuestionId())
                throw new forumException(forumEnums.REPLY_IS_ERROR);
        }
        //文章评论数加1
        questionS.addCommentCount(com.getQuestionId());
        //4.存入数据库
        commentsM.addComment(com);
        return que;
    }

    @Override
    public comments findByComId(int comId) {
        comments com = commentsM.findByComId(comId);
        if (com == null) {
            throw new forumException(forumEnums.COMMENTS_IS_NULL);
        }
        return com;
    }

    @Override
    public List<commentListDto> getComInQuestion(int questionId) {
        int number=0;
        //1.查询该文章所有评论
        List<commentsDto> comDto = commentsM.getComByQue(questionId);
        List<commentListDto> comList = new ArrayList<>();
        //2.组装评论
        while (comDto.size() > 0) {
            List<commentsDto> replyList=new ArrayList<>();      //评论回复的集合
            //文章的第一条评论的ComType一定为0
            List<Integer> replyId = new ArrayList<>();      //评论以及评论的回复的Id
            commentListDto litDto=new commentListDto();
            BeanUtils.copyProperties(comDto.get(0),litDto);
            //将第一条评论的id加入replyId
            replyId.add(litDto.getId());
            /**从comDto删除该文章评论*/
            comDto.remove(0);
            //循环后面的评论，查找后面的评论中回复replyId数组中id的评论
            for (int i = 0;i < comDto.size(); i++) {
                commentsDto co=comDto.get(i);
                for (Integer reId : replyId) {
                    number++;
                    //如果该评论是回复replyId数组中的人，则将该评论的id也加入replyId数组
                    //后面的循环也会查找回复该评论的评论
                    if(co.getReplyId()==reId) {
                        replyList.add(co);
                        /**从comDto删除该评论*/
                        comDto.remove(i);
                        replyId.add(co.getId());
                        i--;
                        break;
                    }
                }
            }
            //所以将所有评论组装到同一个commentListDto对象中
            litDto.setReplyList(replyList);
            comList.add(litDto);
        }
        return comList;
    }
}

