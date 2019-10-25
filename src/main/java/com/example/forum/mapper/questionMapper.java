package com.example.forum.mapper;

import com.example.forum.entity.question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/10/25 14:26
 * @description：question操作数据库的mapper
 */
@Mapper
public interface questionMapper {

    /**
     * 根据主键id查询question
     * @param id
     * @return
     */
    @Select("select * from question where id=#{id}")
    public question findById(int id);

    /**
     * 插入数据
     * @param que
     * @return
     */
    @Insert("insert into question (title,problem_describe,creator,tags) " +
            "values (#{title},#{problemDescribe},#{creator},#{tags})")
    public int insertQue(question que);


}
