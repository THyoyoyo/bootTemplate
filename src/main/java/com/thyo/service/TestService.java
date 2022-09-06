package com.thyo.service;

import com.thyo.dto.UserDto;

public interface TestService {
     public UserDto getUserId(Integer id);
     public void addUser(UserDto user);
}



