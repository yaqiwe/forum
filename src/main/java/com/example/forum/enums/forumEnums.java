package com.example.forum.enums;

import lombok.Getter;

import javax.management.loading.MLetContent;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/10/25 17:18
 * @description：
 */
@Getter
public enum forumEnums {
    UNKNOWN_ERROR(1000,"未知错误，请联系管理员解决或者重新尝试"),
    /*4xx服务端错误*/
    PARAMETER_ERROR(401,"参数校验错误"),

    /*问题service相关异常*/
    QUESTION_IS_NULL(600,"文章不存在"),

    /*用户Service相关异常*/
    USER_IS_NULL(700,"该用户不存在"),

    /*commeentsService相关错误*/
    COMMENTS_IS_NULL(800,"找不到该评论，该评论可能已删除"),
    REPLY_IS_ERROR(801,"回复评论失败"),
    ;

    private Integer code;
    private String msg;

    forumEnums(Integer code, String msg){
        this.code=code;
        this.msg=msg;
    }
}
