package com.example.forum.enums;

import lombok.Getter;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/10/30 16:37
 * @description：WebSocket的回复的类型
 */
@Getter
public enum socketNoticeType {
    QUESTION_NOTICE(2001,"问题的回复"),
    COMMENTS_NOTICE(2002,"评论的回复"),
    LIKE_NOTICE(2003,"问题的点赞"),
    ;

    private Integer code;
    private String msg;

    socketNoticeType(Integer code, String msg){
        this.code=code;
        this.msg=msg;
    }
}
