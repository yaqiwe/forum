package com.example.forum.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/10/26 10:20
 * @description：问题列表，与用户信息的映射类
 */
@Data
public class questionDto {

    private int id;     //自增主键

    private String title;       //问题标题

    private String problemDescribe;     //问题详情

    private int commentCount;     //评论数

    private int viewCount;        //阅读数

    private int likeCount;        //点赞数

    private String tags;    //标签，以,号分隔

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp createTime;       //创建时间

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp updateTime;       //更新时间

    /*----------------问题对应的用户信息--------------*/
    private String name;    //用户名

    private String  avatarUrl;  //用户头像

    private int creator;        //问题发布人的id
}
