package com.example.forum.controller;

import com.example.forum.dto.PageDto;
import com.example.forum.dto.commentListDto;
import com.example.forum.dto.questionDto;
import com.example.forum.entity.question;
import com.example.forum.entity.user;
import com.example.forum.service.commentsService;
import com.example.forum.service.questionService;
import com.example.forum.service.userService;
import com.example.forum.util.Resoult;
import com.example.forum.util.ResoultUtil;
import com.github.pagehelper.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    commentsService commentsS;

    /**
     * 发布问题
     *
     * @param title 问题标题
     * @param text  问题内容
     * @param tag   问题标签
     * @return
     */
    @PostMapping("/release")
    public Resoult release(@RequestParam(value = "title") String title,
                           @RequestParam(value = "text") String text,
                           @RequestParam(value = "tag") String tag) {
        //1.获取当前登录人的id
        int creator = userS.getUser().getId();
        //2.存入数据库
        questionS.releaseQuestion(title, text, creator, tag);
        //3.组装数据返回
        return ResoultUtil.success();
    }

    /**
     * 查询问题列表和对应的发布人信息
     *
     * @param page  页数 默认1
     * @param limit 每页数据数，默认10条
     * @return
     */
    @GetMapping("/getQuestionList")
    public Resoult getQuestionList(@RequestParam(value = "page", defaultValue = "1") int page,
                                   @RequestParam(value = "limit", defaultValue = "10") int limit) {
        //1.查询数据
        Page<questionDto> que = questionS.getQuestionList(page, limit);
        //2.组装数据返回
        PageDto dto = new PageDto();
        dto.setTotalLimit(que.getTotal());
        dto.setTotalpage(que.getPages());
        dto.setData(que.getResult());
        return ResoultUtil.success(dto);
    }

    /**
     * 查看文章详细内容，包含评论,和发布问题的用户信息
     * @param questionId 文章Id
     * @return
     */
    @GetMapping("/getQuestion")
    public Resoult getQuestion(@RequestParam(value = "questionId")int questionId) {
        //1.查询文章
        question que = questionS.getQuestion(questionId);
        //2.查询该文章的评论
        List<commentListDto> com = commentsS.getComInQuestion(que.getId());
        //3.查询发布该文章的用户的信息
        user us = userS.getUserById(que.getCreator());
        //组装数据
        questionDto dto=new questionDto();
        BeanUtils.copyProperties(que,dto);
        BeanUtils.copyProperties(us,dto);
        Map<String,Object> map=new LinkedHashMap<>();
        map.put("question",dto);
        map.put("comments",com);
        return ResoultUtil.success(map);
    }

}
