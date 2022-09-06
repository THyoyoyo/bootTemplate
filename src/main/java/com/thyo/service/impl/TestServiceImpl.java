package com.thyo.service.impl;

import com.thyo.dto.UserDto;
import com.thyo.mapper.TestMapper;
import com.thyo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TestServiceImpl implements TestService {

    @Autowired
    TestMapper testMapper;

    @Override
    public UserDto getUserId(Integer id) {
        UserDto user = testMapper.selectById(id);
        return user;
    }

    @Override
    public void addUser(UserDto user) {
        testMapper.insert(user);
    }
}
