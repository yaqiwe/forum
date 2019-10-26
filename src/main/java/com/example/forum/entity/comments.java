package com.example.forum.entity;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/10/26 14:29
 * @description：评论表
 */
@Data
public class comments {

    private int id;     //自增主键

    @NotNull(message = "评论的文章id不能为空")
    private int questionId;     //评论的文章ID

    @NotNull(message = "评论人的id不能为空")
    private int creator;        //评论人的id

    @NotEmpty(message = "评论内容不能为空")
    private String comText;     //评论的内容

    private int comType=0;      //评论类型:0文章评论，1评论的回复

    private int replyId;    //com_type=1时记录回复的评论的id,com_type=0时没有值

    private Timestamp createTime;       //评论时间，数据库自动创建
}
