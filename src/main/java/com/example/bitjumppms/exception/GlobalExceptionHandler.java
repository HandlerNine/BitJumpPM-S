package com.example.bitjumppms.exception;

import com.example.bitjumppms.domain.BaseResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.ResponseEntity;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public ResponseEntity<BaseResponse> handle(ServiceException se){
        return new ResponseEntity(BaseResponse.error(se.getCode(),se.getMessage()),se.getHttpStatus());
    }
}
