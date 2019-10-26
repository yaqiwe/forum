package com.example.forum.service;

import com.example.forum.dto.questionDto;
import com.example.forum.entity.question;
import com.github.pagehelper.Page;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/10/25 16:54
 * @description：问题操作
 */
@Validated
public interface questionService {

    /**
     * 发布问题,发布失败会被统一异常拦截
     * @param title
     * @param text
     * @param creator
     * @param tag
     */
    void releaseQuestion(@NotEmpty(message = "标题不能为空") String title,
                         @NotEmpty(message = "问题详情不能为空") String text,
                         @NotNull(message = "发布人id不能为空") int creator,
                         String tag);

    /**
     * 分页查询问题列表和发布的用户信息
     * @param page 查询第几页 ,从1开始
     * @param limit 每页有几条数据，从1开始
     * @return
     */
    Page<questionDto> getQuestionList(@Min(value = 1,message = "页数最小值不能小于1") int page,
                                      @Min(value = 1,message = "每页数据条数最小值不能小于1") int limit);

    /**
     * 查询文章详细内容
     * @param questionId
     * @Exception forumException(forumEnums.QUESTION_IS_NULL)
     * @return
     */
    question getQuestion(@NotNull(message = "文章ID不能为空") int questionId);
}
