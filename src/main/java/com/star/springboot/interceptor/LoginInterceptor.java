package com.star.springboot.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.star.springboot.annotation.PassToken;
import com.star.springboot.annotation.UserLogin;
import com.star.springboot.po.User;
import com.star.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName LoginInterceptor
 * @Description 登录拦截器
 * @Author Administrator
 * @Date 2019/11/8 10:23
 * @Version 1.0
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        if (!(handler instanceof HandlerMethod)){
            return true;
        }
        HandlerMethod method = (HandlerMethod)handler;
        if (method.hasMethodAnnotation(PassToken.class)){
            PassToken passToken = method.getMethodAnnotation(PassToken.class);
            if (!passToken.required()){
                return true;
            }
        }
        if (method.hasMethodAnnotation(UserLogin.class)){
            UserLogin userLogin = method.getMethodAnnotation(UserLogin.class);
            if (!userLogin.required()){
                return true;
            }
            if (token == null){
                throw new RuntimeException("token失效，请重新登录");
            }
            String id = JWT.decode(token).getAudience().get(0);
            User user = userService.getUserById(Integer.valueOf(id));
            if (user == null){
                throw new RuntimeException("用户不存在");
            }
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
            try {
                jwtVerifier.verify(token);
            } catch (JWTVerificationException e) {
                throw new RuntimeException("token格式不对");
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
