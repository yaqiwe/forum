package com.example.forum.Exceptions;

import com.example.forum.enums.forumEnums;
import lombok.Data;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/10/25 17:22
 * @description：自定义的错误类型
 */
@Data
public class forumException extends RuntimeException {
    private Integer code;

    public forumException(forumEnums enums){
        super(enums.getMsg());
        code=enums.getCode();
    }
}
