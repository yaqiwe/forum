package com.example.forum.service.impl;

import com.example.forum.Exceptions.forumException;
import com.example.forum.dto.commentListDto;
import com.example.forum.dto.commentsDto;
import com.example.forum.entity.comments;
import com.example.forum.enums.forumEnums;
import com.example.forum.mapper.commentsMapper;
import com.example.forum.service.commentsService;
import com.example.forum.service.questionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public int addComment(comments com) {
        //查看是否存在该问题
        questionS.getQuestion(com.getQuestionId());
        //1.查看评论类型，若评论类型为1，
        if (com.getComType() == 1) {
            //2.查找回复的评论，若找不到抛出异常
            comments RepCom = findByComId(com.getReplyId());
            //3.回复的评论应该和评论属于同一篇文章,否则抛出异常
            if (RepCom.getQuestionId() != com.getQuestionId())
                throw new forumException(forumEnums.REPLY_IS_ERROR);
        }
        //4.存入数据库
        return commentsM.addComment(com);
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
        //1.查询该文章所有评论
        List<commentsDto> comDto = commentsM.getComByQue(questionId);
        //2.将评论组装成 [评论:....,评论的回复:[回复1,.......]]的格式
        List<commentListDto> dto=new ArrayList<>();
        List<commentsDto> replyList = new ArrayList<>();
        /**
         * 1.查找第一个replyId=0的评论
         * 2.将该评论id加到replyId数组里面
         * 3.遍历剩下的评论（评论的回复只能在评论之后，不用遍历该评论之前的评论），
         *      若回复的评论id（replyId）与数组里面的值相等
         *      则将该评论的id也加入replyId数组，从评论comDto集合里面删除该评论的回复
         * 4.将评论和评论的回复加入dto对象里
         * 5.从从评论comDto集合里面删除该评论
         * 6.重复1—5步骤，直到comDto集合为空，反悔呢
         */
        int[] replyId = null;
        for (int i=0;i<comDto.size();) {
            commentsDto co=comDto.get(i);
            if (co.getComType() == 0) {
                replyId=new int[comDto.size()];
                int RI=0;
                replyId[RI++] =co.getId();
                for (int e=i;e<comDto.size();e++) {
                    commentsDto replyDto=comDto.get(e);
                    if(replyDto.getComType()==1){
                        int j=0;
                        while (j<RI){
                            if(replyDto.getReplyId()==replyId[j++]){
                                replyId[RI++] =replyDto.getId();
                                replyList.add(replyDto);
                                comDto.remove(replyDto);
                                break;
                            }
                        }
                    }
                }
            }
            commentListDto listDot=new commentListDto();
            BeanUtils.copyProperties(co,listDot);
            listDot.setReplyList(replyList);
            comDto.remove(co);
            replyList=new ArrayList<>();
            dto.add(listDot);
        }
        return dto;
    }


}
