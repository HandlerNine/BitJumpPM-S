package com.example.bitjumppms.controller;

import com.example.bitjumppms.domain.BaseResponse;
import com.example.bitjumppms.domain.ErrorCode;
import com.example.bitjumppms.exception.GlobalExceptionHandler;
import com.example.bitjumppms.exception.ServiceException;
import com.example.bitjumppms.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import com.chenxf.DB.DBController;

import static com.example.bitjumppms.utils.RSAUtil.decrypt;
import static com.example.bitjumppms.utils.RSAUtil.getPrivateKeyFromPemResource;

@RestController
@Slf4j
//@CrossOrigin(origins = "http://localhost:5173",maxAge = 3600)
public class LoginController {
    private DBController db;
    LoginController() throws IOException {
        db = new DBController();
    }

    @PostMapping("/register/{userid}/{password}")
    // 注册
    public BaseResponse register(@PathVariable String userid, @PathVariable String password,
                                 @RequestBody HashMap<String, String> map,
                                 HttpServletRequest request) throws IOException {
        //处理
        db = new DBController();
        String name = this.db.SelectUserNameByID(userid);

        log.info("request:{}",request);

        if(name == null){
            log.info("userid = {}, password = {}, email = {} ",userid,password,map.get("email"));
            this.db.InsertUser(userid,password,map.get("email"));
            return BaseResponse.success();
        }
        else{
            //失败（默认httpState为400）
            throw new ServiceException(ErrorCode.DUPLICATE_USERNAME,"用户已存在");
        }
    }

    @PostMapping("/login/{userid}/{password}")
    //登录
    public BaseResponse login(@PathVariable String userid, @PathVariable String password) throws Exception {

        //记得写个解密的方法

//        PrivateKey privateKey = getPrivateKeyFromPemResource("rsa_1024_priv.pem");
//        byte[] result = decrypt(Base64.getDecoder().decode(password),privateKey);
//
//        String Password = Arrays.toString(result);

        String Password = password;

//        log.info("userid = {}, password = {}",userid,password);
        Map<String, Object> payload = new HashMap<>();
        payload.put("name","hhh");
        String token = new JwtUtils().createToken(payload,userid); //userid放进subject里，其余的消息放payload里

        String TrustPassword = this.db.SelectUserPasswordByID(userid);

        if( TrustPassword ==null){
            throw new ServiceException(ErrorCode.INVALID_USERNAME,"用户不存在");
        }

        boolean Flag = TrustPassword.equals(Password);
        if( Flag )
            return BaseResponse.success(token);
        else{
            throw new ServiceException(ErrorCode.INVALID_PASSWORD,"密码错误");
        }
    }

    @PostMapping("/logout")
    //退出登录
    public BaseResponse postLogout(){
        return BaseResponse.success();
    }

    @PutMapping("/password/{oldpassword}/{newpassword}")
    //修改密码
    public BaseResponse putPassword(@PathVariable String oldpassword,
                                    @PathVariable String newpassword,
                                    HttpServletRequest request) throws Exception {
        //获取token（我猜要）
        String userId = JwtUtils.getIdFromRequest(request);

//        PrivateKey privateKey = getPrivateKeyFromPemResource("rsa_1024_priv.pem");
//        byte[] result_1 = decrypt(Base64.getDecoder().decode(oldpassword),privateKey);
//        String Old_Password = Arrays.toString(result_1);
//        byte[] result_2 = decrypt(Base64.getDecoder().decode(newpassword),privateKey);
//        String New_Password = Arrays.toString(result_2);
        String Old_Password = oldpassword;
        String New_Password = newpassword;

        log.info("old={}\nnew ={}",Old_Password,New_Password);

        String TrustPassword = this.db.SelectUserPasswordByID(userId);

        if(! Old_Password.equals(TrustPassword) )
            throw new ServiceException(ErrorCode.INVALID_PASSWORD,"密码错误");

        this.db.UpdateUserPassword(userId,New_Password);

        return BaseResponse.success();
    }

}
