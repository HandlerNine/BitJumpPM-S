package com.example.bitjumppms.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse {
    private int code;
    private String message;
    private Object data;

    public static BaseResponse success(){
        return new BaseResponse(ErrorCode.SUCCESS,"success",null);
    }

    public static BaseResponse success(Object data){
        return new BaseResponse(ErrorCode.SUCCESS,"success",data);
    }

    public static BaseResponse error(int code, String msg){
        return new BaseResponse(code,msg,null);
    }
}