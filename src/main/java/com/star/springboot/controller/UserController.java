package com.star.springboot.controller;

import com.star.springboot.annotation.PassToken;
import com.star.springboot.annotation.UserLogin;
import com.star.springboot.po.User;
import com.star.springboot.service.UserService;
import com.star.springboot.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
    public Object login(@RequestBody User user){
        System.out.println(user);
        if (user == null){
            return null;
        }
        User tmp = userService.login(user);
        Map<String, Object> map = new HashMap<>(16);
        map.put("token", JwtUtils.getToken(user));
        map.put("user", tmp);
        return map;
    }

    @PassToken
    @RequestMapping(value = "/print", method = RequestMethod.POST)
    public Object print(User user){
        System.out.println(user);
        Map<String, Object> map = new HashMap<>(16);
        map.put("token", JwtUtils.getToken(user));
        map.put("user", user);
        return map;
    }

    @RequestMapping(value = "/getMessage", method = RequestMethod.GET)
    @UserLogin
    public Object getMessage(){
        return "getMessage";
    }
}
