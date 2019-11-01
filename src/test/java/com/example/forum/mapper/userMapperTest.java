package com.example.forum.mapper;

import com.example.forum.entity.user;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ：yaqiwe
 * @date ：Created in 2019/10/26 15:42
 * @description：
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@RunWith(SpringRunner.class)
class userMapperTest {
    @Autowired
    userMapper userM;

    @Test
    void findById() {
        int id=7;
        user us = userM.findById(id);
        Assert.assertEquals(us.getId(),id);
    }

    @Test
    void findByIdIsNull() {
        int id=50000;
        user us = userM.findById(id);
        Assert.assertNull(us);
    }
}