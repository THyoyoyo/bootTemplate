package com.thyo.controller;


import com.thyo.dto.UserDto;
import com.thyo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
@RestController
@RequestMapping("user")
public class TestController {
    @Autowired
    TestService testService;

    @GetMapping("/info")
    public HashMap<Object, Object> getUserId(@RequestParam("id") Integer id){
        HashMap<Object, Object> map = new HashMap<>();
        UserDto user = testService.getUserId(id);
        map.put("code",200);
        map.put("data",user);
        return  map;
    }

    @PostMapping("/add")
    public HashMap<Object, Object> addUser(@RequestBody UserDto user){
        HashMap<Object, Object> map = new HashMap<>();
        testService.addUser(user);
        map.put("code",200);
        return  map;
    }
}
