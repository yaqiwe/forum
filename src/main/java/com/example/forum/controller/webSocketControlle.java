package com.example.forum.controller;

import com.example.forum.Exceptions.forumException;
import com.example.forum.enums.forumEnums;
import com.example.forum.util.Resoult;
import com.example.forum.util.ResoultUtil;
import com.example.forum.webSocket.noticeSocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/10/30 17:08
 * @description：测试webSocket
 */
@RestController
public class webSocketControlle {

    @Autowired
    noticeSocket socket;


    @GetMapping("senMessage")
    public Resoult senMessage(int id){
        try {
            boolean iS = socket.notice(id, ResoultUtil.success("发送消息测试"));
            if (iS){
                return ResoultUtil.success();
            }else {
                return ResoultUtil.error(110100,"用户不在线");
            }
        } catch (IOException e) {
            throw new forumException(forumEnums.SEND_MESSAGE_ERROR);
        }
    }
}
