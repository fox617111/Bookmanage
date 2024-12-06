package org.example.backend.configuration;


import org.example.backend.interceotor.AuthenticationInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(@NonNull InterceptorRegistry registry) {
        List<String> excludePathLists = new ArrayList<>();
        //注册、登录允许访问，不进行拦截
        excludePathLists.add("/user/login");
        excludePathLists.add("/user/register");
//        excludePathLists.add("/user/info");
        //addPathPatterns("/**") 表示这个拦截器会拦截所有的请求路径（/** 指的是所有路径）。
//        excludePathPatterns(excludePathLists) 方法用于排除先前定义的路径。这样，当请求这些特定路径时，拦截器将不会被触发。
         registry.addInterceptor(new AuthenticationInterceptor()).addPathPatterns("/**").excludePathPatterns(excludePathLists);
    }
}
