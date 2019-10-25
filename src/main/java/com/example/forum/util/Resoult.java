package com.example.forum.util;

import lombok.Data;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/10/25 17:14
 * @description：数据返回的模板
 */
@Data
public class Resoult <T>{

    private Integer code;   /*正确&错误放回吗*/

    private String msg;     /*返回信息*/

    private T data;     /*请求的数据*/
}
