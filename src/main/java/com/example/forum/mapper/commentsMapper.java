package com.example.forum.mapper;

import com.example.forum.dto.commentsDto;
import com.example.forum.entity.comments;
import com.example.forum.mapper.mapperSql.commentsMapperSql;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/10/26 14:42
 * @description：评论表数据库操作的mapper
 */
public interface commentsMapper {
    /**
     * 给comments表插入数据
     * @param com
     * @return
     */
    @InsertProvider(type = commentsMapperSql.class,method = "insertComment")
    int addComment(comments com);

    /**
     * 根据评论id查找评论
     * @param comId
     * @return
     */
    @Select("Select * From comments where id=#{comId}")
    comments findByComId(int comId);

    /**
     * 查找一篇文章的所有评论及评论的用户信息
     * @param questionId
     * @return
     */
    @Select("Select user.name,user.avatar_url,comments.* from comments LEFT JOIN user on comments.creator=`user`.id WHERE comments.question_id=#{questionId}")
    List<commentsDto> getComByQue(int questionId);
}
