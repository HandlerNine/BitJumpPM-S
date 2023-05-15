package com.example.bitjumppms.interceptors;

import com.example.bitjumppms.domain.ErrorCode;
import com.example.bitjumppms.exception.ServiceException;
import com.example.bitjumppms.utils.JwtUtils;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
public class JwtInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler){

        //获取请求头中的令牌
        String token = request.getHeader("token");
        JwtUtils jwtUtils = new JwtUtils();
        try{
            return jwtUtils.isTokenExpired(token);//用这一个就能全部过一遍
        }catch (ExpiredJwtException e){
            throw new ServiceException(ErrorCode.EXPIRED_TOKEN,"token过期", HttpStatus.FORBIDDEN);
        }catch (MalformedJwtException e){
            throw new ServiceException(ErrorCode.INVALID_TOKEN,"token错误",HttpStatus.FORBIDDEN);
        }catch (SignatureException e){
            throw new ServiceException(ErrorCode.INVLAID_SIGNATURE,"token签名错误",HttpStatus.FORBIDDEN);
        }
    }
}
