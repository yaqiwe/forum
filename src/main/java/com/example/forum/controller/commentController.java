package com.example.forum.controller;

import com.example.forum.entity.comments;
import com.example.forum.entity.question;
import com.example.forum.entity.user;
import com.example.forum.service.commentsService;
import com.example.forum.service.noticeService;
import com.example.forum.service.userService;
import com.example.forum.util.Resoult;
import com.example.forum.util.ResoultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/10/26 17:45
 * @description：评论相关Controller
 */
@RestController
@RequestMapping("/comment")
public class commentController {

    @Autowired
    commentsService commentsS;
    @Autowired
    userService userS;
    @Autowired
    noticeService noticeS;

    /**
     * 发表评论&回复评论
     * @param com
     * @return
     */
    @PostMapping("/addComment")
    public Resoult addComment(comments com) throws IOException {
        user us=userS.getUser();
        com.setCreator(us.getId());
        //评论
        question que = commentsS.addComment(com);
        //通知
        noticeS.questionNotice(us.getName(),que);
        return ResoultUtil.success();
    }
}
