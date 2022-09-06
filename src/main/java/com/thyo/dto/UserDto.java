package com.thyo.dto;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@TableName("user_info")
public class UserDto {
   @TableId(type = IdType.AUTO)
   private Integer id;

   private String name;
   private String phone;
   private String sex;
   private Integer age;
   private Date created;
   private BigDecimal money;
}
