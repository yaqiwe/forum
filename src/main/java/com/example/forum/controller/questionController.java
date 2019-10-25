package com.example.forum.controller;

import com.example.forum.service.questionService;
import com.example.forum.service.userService;
import com.example.forum.util.Resoult;
import com.example.forum.util.ResoultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/10/25 16:52
 * @description：问题操作相关controller
 */
@RestController
@RequestMapping("/question")
public class questionController {

    @Autowired
    questionService questionS;

    @Autowired
    userService userS;

    @PostMapping("/release")
    public Resoult release(@RequestParam(value = "title") String title,
                           @RequestParam(value = "text") String text,
                           @RequestParam(value = "tag") String tag) {
        //1.获取当前登录人的id
        int creator=userS.getUser().getId();
        //2.存入数据库
        questionS.releaseQuestion(title,text,creator,tag);
        //3.组装数据返回
        return ResoultUtil.success();
    }
}
