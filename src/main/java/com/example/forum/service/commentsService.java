package com.example.forum.service;

import com.example.forum.dto.commentListDto;
import com.example.forum.entity.comments;

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
     */
    public int addComment(comments com);

    /**
     * 查找评论
     * @param comId
     * @Exception forumException(forumEnums.COMMENTS_IS_NULL)
     * @return
     */
    public comments findByComId(int comId);

    /**
     * 查找一篇文章的评论
     * @param questionId
     * @return
     */
    public List<commentListDto> getComInQuestion(int questionId);
}
