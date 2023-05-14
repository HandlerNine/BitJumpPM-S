package com.example.bitjumppms.exception;

import com.example.bitjumppms.domain.BaseResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

public class GlobalExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public BaseResponse handle(ServiceException se){
        return BaseResponse.error(se.getCode(),se.getMessage());
    }
}
