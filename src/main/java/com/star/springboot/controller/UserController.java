package com.star.springboot.controller;

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

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Object login(@RequestBody User user){
        if (user == null){
            return null;
        }
        User tmp = userService.login(user);
        Map<String, Object> map = new HashMap<>(16);
        map.put("token", JwtUtils.getToken(user));
        map.put("user", tmp);
        return map;
    }

    @RequestMapping(value = "/getMessage", method = RequestMethod.GET)
    @UserLogin
    public Object getMessage(){
        return "getMessage";
    }
}
