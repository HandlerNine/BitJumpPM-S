package com.example.bitjumppms.utils;

import com.example.bitjumppms.domain.ErrorCode;
import com.example.bitjumppms.exception.ServiceException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtils {

    private static String SECRET_KEY = "token!Q@W#E$R";
    /**
     * 生成token
     */
    public String createToken(Map<String, Object> claims, String subject) {
        long now = System.currentTimeMillis();
//        long expirationTime = now + 10000 * 60 * 60;

        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE, 7); //默认7天过期

        return Jwts.builder()
                .setClaims(claims)//载荷
                .setSubject(subject)//用户名
                .setIssuedAt(new Date(now))//当前时间
//                .setExpiration(new Date(expirationTime))//过期时间
                .setExpiration(instance.getTime())//过期时间
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)//签名
                .compact();
    }
    /**
     * 获取
     */
    private static Claims extractAllClaims(String token) { //获取所有负载
         return Jwts.parser().
                    setSigningKey(SECRET_KEY).
                    parseClaimsJws(token).
                    getBody();
    }

    public static String extractUserid(String token){ //获取用户名
        Claims claims = extractAllClaims(token);
        return claims.getSubject();
    }

    public static String getIdFromRequest(HttpServletRequest request){
        String token = request.getHeader("token");
        return extractUserid(token);
    }
    /**
     * 验证token
     */
    public Boolean isTokenExpired(String token) {  //是否超时
        Claims claims = extractAllClaims(token);
        Date expiredDate = claims.getExpiration();
        return expiredDate.before(new Date());
    }

    public boolean validateUserid(String token, String myid) {  //是否有这个人
        String userid = extractUserid(token);
        return userid.equals(myid);
    }

}
