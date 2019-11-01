package com.example.forum.service;

import com.example.forum.entity.question;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.io.IOException;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/10/31 13:30
 * @description：包装webSocket实现实时消息通信
 */
@Validated
public interface noticeService {

    /**
     * 问题的回复——通知问题发布人
     * @param userName 回复该问题的人的用户名
     * @param que 回复的文章
     */
    public void questionNotice(@NotNull(message = "[noticeService]:回复的用户不能为空") String userName,
                               question que) throws IOException;
}
