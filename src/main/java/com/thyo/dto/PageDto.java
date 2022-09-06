package com.thyo.dto;

import lombok.Data;

import java.util.List;

@Data
public class PageDto<T> {
 private  Long pageNum;
 private  Long pageSize;
 private  Long total;
 private  Long pages;
 private  List<T> list;
}
