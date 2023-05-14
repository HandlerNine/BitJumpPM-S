package com.example.bitjumppms.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BaseResponse<T> {
    private int code;
    private String message;
    private T data;

    public static <T> BaseResponse success(){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.code = 200;
        baseResponse.message = "success";
        baseResponse.data = null;
        return baseResponse;
    }

    public static <T> BaseResponse success(T data){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.code = 200;
        baseResponse.message = "success";
        baseResponse.data = data;
        return baseResponse;
    }
}
