package com.example.forum.mapper.mapperSql;

import com.example.forum.entity.comments;
import org.apache.ibatis.jdbc.SQL;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/10/26 14:53
 * @description：comments查询动态生成sql
 */
public class commentsMapperSql {

    /**
     * 动态生成插入评论的sql
     *
     * @param com
     * @return
     */
    public String insertComment(comments com) {
        return new SQL() {
            {
                INSERT_INTO("comments");
                //若评论类型为1，则插入回复的评论的id
                if (com.getComType() == 1)
                    VALUES("reply_id", "#{replyId}");
                VALUES("question_id","#{questionId}");
                VALUES("creator","#{creator}");
                VALUES("com_text","#{comText}");
                VALUES("com_type","#{comType}");
            }
        }.toString();

    }
}
