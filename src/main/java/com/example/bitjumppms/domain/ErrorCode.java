package com.example.bitjumppms.domain;

public interface ErrorCode {
    String SUCCESS = "200";//成功
    String DUPLICATE_USERNAME = "40001";//账号重复
    String INVALID_USERNAME = "40002";//账号不存在
    String INVALID_PASSWORD = "40003";//密码错误
}
