package com.example.forum.service.impl;

import com.example.forum.dto.questionDto;
import com.example.forum.entity.question;
import com.example.forum.mapper.questionMapper;
import com.example.forum.service.questionService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Min;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/10/25 17:04
 * @description：问题操作的实现类
 */
@Service
public class questionServiceImpl  implements questionService {

    @Autowired
    questionMapper questionM;

    @Override
    public void releaseQuestion(String title,String text, int creator, String tag) {
        question que=new question(title,text,creator,tag);
        questionM.insertQue(que);
    }

    @Override
    public Page<questionDto> getQuestion(int page,int limit) {
        PageHelper.startPage(page,limit,"create_time DESC");
        Page<questionDto> dto = questionM.finAllByQuesAndUser();
        return dto;
    }
}
