package com.example.forum.dto;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import javax.websocket.Session;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/10/30 16:28
 * @description：webSocket连接的用户信息
 */
@Data
@Validated
public class socketDto {

    private Integer userId;     //连接的用户Id

    private Session session;       //连接的用户Session

    public socketDto(@NotNull(message = "连接Socket的用户Id不能为空") Integer userId,
                     @NotNull(message = "连接Socket的用户Session不能为空") Session session) {
        this.userId = userId;
        this.session = session;
    }
}
