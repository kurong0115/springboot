package com.star.springboot.service.impl;

import com.star.springboot.annotation.RedisCache;
import com.star.springboot.po.User;
import com.star.springboot.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserServiceImpl
 * @Description 实现类
 * @Author Administrator
 * @Date 2019/11/8 10:11
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    @RedisCache
    public User login(User user) {
        if (user == null){
            return null;
        }
        if ("kurong".equalsIgnoreCase(user.getUsername()) && "123456".equalsIgnoreCase(user.getPassword())){
            User tmp = new User();
            user.setId(1024);
            tmp.setUsername("kurong");
            tmp.setPassword("123456");
            return tmp;
        }
        return null;
    }

    @Override
    public User getUserById(Integer id) {
        if (!id.equals(1024)){
            return null;
        }
        User user = new User();
        user.setUsername("kurong");
        user.setPassword("123456");
        user.setId(1024);
        return user;
    }
}
