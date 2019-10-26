package com.example.forum.dto;

import lombok.Data;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/10/26 11:02
 * @description：分页查询的Dto
 */
@Data
public class PageDto<T> {

    private int totalpage;      //总页数

    private long totalLimit;     //总数据数量

    private T data;     //查询的数据
}
