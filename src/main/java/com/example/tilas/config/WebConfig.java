package com.example.tilas.config;

import com.example.tilas.interceptor.TokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private TokenInterceptor tokenInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List excludePathPatterns = List.of("/login", "/register");
        registry.addInterceptor(tokenInterceptor).addPathPatterns("/**").excludePathPatterns(excludePathPatterns);
    }
}
