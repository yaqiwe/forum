package com.example.forum.service;

import com.example.forum.dto.commentListDto;
import com.example.forum.entity.comments;
import com.example.forum.entity.question;
import org.springframework.validation.annotation.Validated;

import java.io.IOException;
import java.util.List;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/10/26 15:24
 * @description：评论相关service
 */
public interface commentsService {
    /**
     * 发表评论&回复评论
     * @param com
     * @return
     */
    public question addComment(@Validated comments com);

    /**
     * 查找评论
     * @param comId
     * @Exception forumException(forumEnums.COMMENTS_IS_NULL)
     * @return
     */
    public comments findByComId(int comId);

    /**
     * 查找一篇文章的评论
     * @param questionId 文章ID
     * @return
     */
    public List<commentListDto> getComInQuestion(int questionId);
}
