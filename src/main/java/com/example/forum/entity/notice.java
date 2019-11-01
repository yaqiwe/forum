package com.example.forum.entity;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/10/31 14:54
 * @description：通知表实体类,已读的信息会从通知表中删除
 */
@Data
public class notice {

    private int id;     //自增主键

    private String userName;     //回复该问题或评论的用户名

    private int questionId;     //回复的问题的Id

    private int noticeUser;     //通知的用户的Id

    private String questionTitle;       //回复的文章标题

    private int isNotice=0;      //通知是否已读，0为未读，1为已读

    private Timestamp createTime;   //通知的创建时间

}
