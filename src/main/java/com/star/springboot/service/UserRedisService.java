package com.star.springboot.service;

import com.star.springboot.po.User;

/**
 * @ClassName UserRedisService
 * @Description TODO
 * @Author Administrator
 * @Date 2019/11/6 18:45
 * @Version 1.0
 */
public interface UserRedisService {

    /**
     * 保存用户信息到Redis
     * @param user
     */
    void saveUser(User user);

    String getAge(String key);
}
