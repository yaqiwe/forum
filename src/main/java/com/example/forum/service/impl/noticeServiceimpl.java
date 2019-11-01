package com.example.forum.service.impl;

import com.example.forum.entity.notice;
import com.example.forum.entity.question;
import com.example.forum.mapper.noticeMapper;
import com.example.forum.service.noticeService;
import com.example.forum.service.userService;
import com.example.forum.util.ResoultUtil;
import com.example.forum.webSocket.noticeSocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/10/31 13:45
 * @description：消息即使通知的实现类
 */
@Service
public class noticeServiceimpl implements noticeService {

    @Autowired
    noticeSocket socket;

    @Autowired
    noticeMapper noticeM;

    @Autowired
    userService userS;

    @Override
    public void questionNotice(String userName, question que) throws IOException {
        notice no=new notice();
        no.setUserName(userName);
        no.setNoticeUser(que.getCreator());
        no.setQuestionId(que.getId());
        no.setQuestionTitle(que.getTitle());
        //写到用户通知表里
        noticeM.addNotice(no);
        //通知用户，如果用户在线
        socket.notice(que.getCreator(), ResoultUtil.success(no));
    }
}
