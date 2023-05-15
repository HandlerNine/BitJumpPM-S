package com.example.bitjumppms.config;

import com.example.bitjumppms.interceptors.JwtInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by Chilly Cui on 2020/9/9.
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JwtInterceptor())
                .addPathPatterns("/project/**")
                .addPathPatterns("/me/**")
                .excludePathPatterns("/login")
                .excludePathPatterns("/register")
        ;
    }
}
