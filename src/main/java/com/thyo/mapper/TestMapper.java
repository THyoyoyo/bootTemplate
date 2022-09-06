package com.thyo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.thyo.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestMapper extends BaseMapper<UserDto> {
}
