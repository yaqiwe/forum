package com.example.forum.entity;

import lombok.Data;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/10/25 19:50
 * @description：用户实体类
 */
@Data
public class user {

    private int id;     //自增主键

    private String name;    //用户名

    private int accountId;      //github返回的id

    private String bio;     //用户描述

    private String  avatarUrl;  //用户头像
}
