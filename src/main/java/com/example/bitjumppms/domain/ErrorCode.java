package com.example.bitjumppms.domain;

public interface ErrorCode {
    int SUCCESS = 200;//成功
    int DUPLICATE_USERNAME = 40001;//账号重复
    int INVALID_USERNAME = 40002;//账号不存在
    int INVALID_PASSWORD = 40003;//密码错误

    int EXPIRED_TOKEN = 40301;//token过期
    int INVALID_TOKEN = 40302;//token解析错误
    int INVALID_TOKENUSER = 40303;//token用户名错误

    int INVLAID_SIGNATURE = 40304;//token签名错误

    int MISS_TOKEN = 40305;//没有token
}
