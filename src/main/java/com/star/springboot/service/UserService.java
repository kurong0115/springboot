package com.star.springboot.service;

import com.star.springboot.po.User;

/**
 * @ClassName UserService
 * @Description 用户业务
 * @Author Administrator
 * @Date 2019/11/8 10:09
 * @Version 1.0
 */
public interface UserService {

    /**
     * 模拟用户登录
     * @param user
     * @return
     */
    User login(User user);

    /**
     * 根据用户主键获取用户对象
     * @param id
     * @return
     */
    User getUserById(Integer id);
}
