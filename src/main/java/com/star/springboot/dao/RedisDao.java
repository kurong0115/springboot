package com.star.springboot.dao;

import com.star.springboot.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.stereotype.Repository;

import java.util.Map;

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
	RedisTemplate<String,Object> redisTemplate;

    public void set(String key, String value){
		redisTemplate.opsForValue().set(key, value);
    }

    public String get(String key){
        return redisTemplate.opsForValue().get(key).toString();
    }

    public void hset(String key, Object hash, Object value){
		redisTemplate.opsForHash().put(key, hash, value);
    }

    public Map<Object, Object> hgetAll(String key){
		return redisTemplate.opsForHash().entries(key);
	}

	public Object hget(String key, String item){
    	return redisTemplate.opsForHash().get(key, item);
	}

	public void putAll(String key, Map<String, Object> map){
    	redisTemplate.opsForHash().putAll(key, map);
	}
}
