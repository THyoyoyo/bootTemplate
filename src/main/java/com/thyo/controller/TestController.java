package com.thyo.controller;


import com.thyo.dto.UserDto;
import com.thyo.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
@RestController
@RequestMapping("user")
@Api(tags = "测试接口")
public class TestController {
    @Autowired
    TestService testService;


    @ApiOperation(value = "根据ID查询用户")
    @GetMapping("/info")
    public HashMap<Object, Object> getUserId(@RequestParam("id") Integer id){
        HashMap<Object, Object> map = new HashMap<>();
        UserDto user = testService.getUserId(id);
        map.put("code",200);
        map.put("data",user);
        return  map;
    }


    @ApiOperation(value = "新增用户")
    @PostMapping("/add")
    public HashMap<Object, Object> addUser(@RequestBody UserDto user){
        HashMap<Object, Object> map = new HashMap<>();
        testService.addUser(user);
        map.put("code",200);
        return  map;
    }



    @ApiOperation(value = "用户登录")
    @GetMapping("/userLogin")
    public HashMap<String, Object> userLogin(HttpSession session) {
        HashMap<String, Object> map = new HashMap<>();
        session.setAttribute("loginToken", new Date());
        map.put("code", 200);
        map.put("message","登录成功");
        return map;
    }

    @ApiOperation(value = "用户退出登录")
    @GetMapping("/userOut")
    public  HashMap<String, Object>  userOut(HttpSession session){
        HashMap<String, Object> map = new HashMap<>();
        session.removeAttribute("loginToken");
        map.put("code", 200);
        map.put("message","已退出登录");
        return map;
    }
}
