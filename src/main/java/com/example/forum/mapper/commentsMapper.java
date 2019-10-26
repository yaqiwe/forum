package com.example.forum.mapper;

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

    @Select("Select * From comments where id=#{comId}")
    comments findByComId(int comId);
}
