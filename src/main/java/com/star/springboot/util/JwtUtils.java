package com.star.springboot.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.star.springboot.po.User;

/**
 * @ClassName JwtUtils
 * @Description 用户验证token
 * @Author Administrator
 * @Date 2019/11/8 10:40
 * @Version 1.0
 */
public class JwtUtils {

    public static String getToken(User user){
        String token = "";
        token = JWT.create().withAudience(user.getId().toString()).sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }
}
