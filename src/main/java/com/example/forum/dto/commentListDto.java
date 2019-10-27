package com.example.forum.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/10/27 10:09
 * @description：放回前端的评论的格式
 */
@Data
public class commentListDto extends commentsDto {

    List<commentsDto> replyList;    //该评论的回复列表
}
