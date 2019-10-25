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
    ;

    private Integer code;
    private String msg;

    forumEnums(Integer code, String msg){
        this.code=code;
        this.msg=msg;
    }
}
