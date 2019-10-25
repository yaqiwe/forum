package com.example.forum.util;

import com.example.forum.enums.forumEnums;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/10/25 17:17
 * @description：
 */
public class ResoultUtil {

    //成功
    public static Resoult success(Object data){
        Resoult resoult=new Resoult();
        resoult.setCode(200);
        resoult.setMsg("成功");
        resoult.setData(data);
        return resoult;
    }

    public static Resoult success(){
        return success(null);
    }

    //失败
    public static Resoult error(Integer code,String msg){
        Resoult resoult=new Resoult();
        resoult.setCode(code);
        resoult.setMsg(msg);
        return resoult;
    }

    public static Resoult error(forumEnums enums){
        return error(enums.getCode(),enums.getMsg());
    }
}
