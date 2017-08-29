package com.yuchang.redis.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 针对redis的集成后效果的测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RedisExampleApplication.class)
public class RedisExampleApplicationTest {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Test
    public void testRedisSetAndGet(){
        String key = "Hello";
        String value = "World";
        redisTemplate.opsForValue().set(key,value);
        String resFromRedis = redisTemplate.opsForValue().get(key);
        Assert.assertTrue(resFromRedis.equals(value));
    }
}
