package com.thyo.config;


import com.thyo.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig  implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

//        registry.addInterceptor(new LoginInterceptor());
                //所有请求都被拦截包括静态资源
//                .addPathPatterns("/**");
//                .excludePathPatterns("/userLogin","/");
                //放行的请求
//                .excludePathPatterns("/", "/login", "/css/**", "/fonts/**", "/images/**",
//                        "/js/**", "/aa/**");
    }
}