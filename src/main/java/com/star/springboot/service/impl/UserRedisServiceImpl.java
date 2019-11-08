package com.star.springboot.service.impl;

import com.star.springboot.dao.RedisDao;
import com.star.springboot.po.User;
import com.star.springboot.service.UserRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void saveUser(User user) {
        redisDao.hset("user", "user1", user);
    }

    @Override
    public String getAge(String key) {
        return redisDao.get(key);
    }
}
