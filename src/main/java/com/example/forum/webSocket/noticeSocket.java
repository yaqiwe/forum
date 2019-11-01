package com.example.forum.webSocket;

import com.alibaba.fastjson.JSON;
import com.example.forum.dto.socketDto;
import com.example.forum.util.Resoult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/10/30 16:12
 * @description： webSocket实现评论&消息通知
 */
@ServerEndpoint("/noticeSocket/{id}")
@Component
@Slf4j
public class noticeSocket {

    private Session session;    //连接的用户对象

    private static CopyOnWriteArraySet<socketDto> sessionSet=new CopyOnWriteArraySet<>();

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(@PathParam(value = "id")int id, Session session) {
        log.info("WebSocket 开始连接:{}",session);
        this.session=session;
        sessionSet.add(new socketDto(id,session));
        log.info("有连接加入，当前连接数为：{}:用户Id：{}", sessionSet.size(),id);
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(Session session) {
        for (socketDto dto : sessionSet) {
            if(session.equals(dto.getSession())){
                sessionSet.remove(dto);
                break;
            }
        }
        log.info("有连接关闭，当前连接数为：{}",  sessionSet.size());
    }

    /**
     * 收到客户端消息后调用的方法
     * @param message 客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        log.info("来自客户端的消息：{}",message);
    }

    /**
     * 出现错误
     */
    @OnError
    public void onError(Session session, Throwable error) {
        log.error("发生错误：{}，Session ID： {}",error.getMessage(),session.getId());
        error.printStackTrace();
    }

    /**
     * 发送信息通知连接的人
     * @param id
     * @param resoult
     * @return  返回false表示用户不在线,放回True表示发送成功
     * @throws IOException
     */
    public boolean notice(int id, Resoult resoult) throws IOException {
        boolean IsOnLine=false;
        for (socketDto dto : sessionSet) {
            if(id==dto.getUserId()){
                //发送消息
                dto.getSession().getBasicRemote().sendText(JSON.toJSONString(resoult));
                IsOnLine=true;
                break;
            }
        }
        return IsOnLine;
    }
}
