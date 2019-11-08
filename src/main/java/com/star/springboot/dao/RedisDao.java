package com.star.springboot.dao;

import com.star.springboot.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

/**
 * @ClassName RedisDao
 * @Description TODO
 * @Author Administrator
 * @Date 2019/11/6 18:32
 * @Version 1.0
 */
@Repository
public class RedisDao {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    public void set(String key, String value){
        stringRedisTemplate.opsForValue().set(key, value);
    }

    public String get(String key){
        return stringRedisTemplate.opsForValue().get(key);
    }

    public void hset(String key, Object hash, Object value){
        stringRedisTemplate.opsForHash().put(key, hash, value);
    }
}
