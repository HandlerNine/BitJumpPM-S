package com.example.bitjumppms.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ServiceException extends RuntimeException{

    private int code;
    private HttpStatus httpStatus = HttpStatus.BAD_REQUEST;//默认是400

    public ServiceException(int code, String msg){
        super(msg);
        this.code = code;
    }

    public ServiceException(int code, String msg, HttpStatus httpStatus){
        super(msg);
        this.code = code;
        this.httpStatus = httpStatus;
    }

}
