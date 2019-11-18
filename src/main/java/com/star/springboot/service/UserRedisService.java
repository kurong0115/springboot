package com.star.springboot.service;

import com.star.springboot.po.User;

import java.util.Map;

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

    /**
     * 获取年龄
     * @param key
     * @return
     */
    String getAge(String key);

	/**
	 * 获取所有的键值对
	 * @param key
	 * @return
	 */
	Map<Object, Object> hgetAll(String key);

	/**
	 * 获取hash中的键的值
	 * @param key
	 * @param item
	 * @return
	 */
	Object hget(String key, String item);

	/**
	 * 将map存入数据库
	 * @param key
	 */
	void putAll(String key, Map<String, Object> map);
}
