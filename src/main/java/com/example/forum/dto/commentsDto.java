package com.example.forum.dto;

import lombok.Data;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/10/27 9:50
 * @description：评论的Dto
 */
@Data
public class commentsDto {

    private int id;     //自增主键

    private String comText;     //评论的内容

    private int comType=0;      //评论类型:0文章评论，1评论的回复

    private int replyId;    //com_type=1时记录回复的评论的id,com_type=0时没有值

    private String name;    //用户名

    private String  avatarUrl;  //用户头像

}
