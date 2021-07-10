package com.example.test;

import com.example.RedisApplication;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;


/**
 * @author XiongJinChen
 * @version 1.0
 * @date 2021/5/6 11:25
 * <p>
 * RedisTest
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {RedisApplication.class})
public class RedisTest {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test1(){
        SetOperations setOperations = redisTemplate.opsForSet();
        setOperations.add("key","Hello");
        RedisOperations operations = setOperations.getOperations();
        System.out.println("过期时长"+operations.getExpire("key"));
        Object key = operations.opsForSet().pop("key");
        System.out.println(key);
    }

}
