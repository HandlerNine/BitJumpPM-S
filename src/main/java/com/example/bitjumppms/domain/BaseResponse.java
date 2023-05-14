package com.example.bitjumppms.domain;

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

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
