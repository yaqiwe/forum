package com.example.forum.mapper;

import com.example.forum.entity.notice;
import org.apache.ibatis.annotations.Insert;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/10/31 15:01
 * @description：操作数据库的notice表
 */
public interface noticeMapper {

    /**
     * 创建通知
     * @param no
     * @return
     */
    @Insert("insert into notice(user_uame,question_id,notice_user,question_title,is_notice) " +
            "values (#{userName},#{questionId},#{noticeUser},#{questionTitle},#{isNotice})")
    int addNotice(notice no);
}
