package com.example.forum.entity;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/10/25 14:16
 * @description：对应数据库 问题表 的实体类
 */
@Data
public class question {

    private int id;     //自增主键

    private String title;       //问题标题

    private String problemDescribe;     //问题描述

    private int creator;        //问题发布人的id

    private int commentCount = 0;     //评论数，默认0

    private int viewCount = 0;        //阅读数，默认0

    private int likeCount = 0;        //点赞数，默认0

    private String tags;    //标签，以,号分隔

    private Timestamp createTime;       //创建时间，数据库自动生成

    private Timestamp updateTime;       //更新时间，数据库自动生成

    public question(String title, String problemDescribe, int creator, String tags) {
        this.title = title;
        this.problemDescribe = problemDescribe;
        this.creator = creator;
        this.tags = tags;
    }

    public question() {
    }
}
