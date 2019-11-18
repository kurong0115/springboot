package com.star.springboot.service.impl;

import com.star.springboot.dao.RedisDao;
import com.star.springboot.po.User;
import com.star.springboot.service.UserRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @ClassName UserRedisServiceImpl
 * @Description TODO
 * @Author Administrator
 * @Date 2019/11/6 18:49
 * @Version 1.0
 */
@Service
public class UserRedisServiceImpl implements UserRedisService {

    @Autowired
    RedisDao redisDao;

	@Override
	public Map<Object, Object> hgetAll(String key) {
		return redisDao.hgetAll(key);
	}

	@Override
	public Object hget(String key, String item) {
		return redisDao.hget(key, item);
	}

	@Override
	public void putAll(String key, Map<String, Object> map) {
		redisDao.putAll(key, map);
	}

	@Override
    public void saveUser(User user) {
        redisDao.hset("user", "user", user);
    }

    @Override
    public String getAge(String key) {
        return redisDao.get(key);
    }
}
