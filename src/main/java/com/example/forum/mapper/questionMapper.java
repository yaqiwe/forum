package com.example.forum.mapper;

import com.example.forum.dto.questionDto;
import com.example.forum.entity.question;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/10/25 14:26
 * @description：question操作数据库的mapper
 */
public interface questionMapper {

    /**
     * 根据主键id查询question
     * @param id
     * @return
     */
    @Select("select * from question where id=#{id}")
    public question findById(int id);

    /**
     * 插入数据
     * @param que
     * @return
     */
    @Insert("insert into question (title,problem_describe,creator,tags) " +
            "values (#{title},#{problemDescribe},#{creator},#{tags})")
    public int insertQue(question que);

    @Select("select * from question")
    public Page<question> finAll();

    /**
     * 联表查询问题表和用户表
     * @return 问题详情
     */
    @Select("select user.name,user.avatar_url,question.* FROM question LEFT OUTER JOIN user on question.creator=user.id")
    public Page<questionDto> finAllByQuesAndUser();

    /**
     * 更新数据库表文章阅读数加一
     * @param questionId 文章ID
     * @return
     */
    @Update("UPDATE question SET view_count=view_count+1 WHERE id=#{questionId}")
    public int addViewCount(int questionId);

    /**
     * 更新数据库表文章评论数加一
     * @param questionId
     * @return
     */
    @Update("UPDATE question SET comment_count=comment_count+1 WHERE id=#{questionId}")
    public int addCommentCount(int questionId);
}
