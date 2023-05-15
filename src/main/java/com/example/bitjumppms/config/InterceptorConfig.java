package com.example.bitjumppms.config;

import com.example.bitjumppms.interceptors.JwtInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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
