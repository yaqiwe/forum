package com.example.forum.service;

import org.springframework.validation.annotation.Validated;

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
     *
     * @param title
     * @param text
     * @param creator
     * @param tag
     */
    void releaseQuestion(@NotEmpty(message = "标题不能为空") String title,
                         @NotEmpty(message = "问题详情不能为空") String text,
                         @NotNull(message = "发布人id不能为空") int creator,
                         String tag);
}
