package com.thyo.interceptor;

import com.thyo.annotation.Token;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.lang.Nullable;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class LoginInterceptor implements HandlerInterceptor {


    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Token annotation;

        if(handler instanceof HandlerMethod) {
            annotation = ((HandlerMethod) handler).getMethodAnnotation(Token.class);
        }else{
            return true;
        }

        //没有声明需要权限,或者声明不验证权限
        if(annotation == null || annotation.validate() == false){
            return true;
        }


        //登录检查逻辑
        HttpSession session = request.getSession();
        Object loginToken = session.getAttribute("loginToken");

        if(loginToken != null){
            //放行
            return true;
        }

        Map<String, Object> map = new HashMap<>();
        map.put("code",401);
        map.put("message","请登录后尝试");
        JSONObject jsonObject = new JSONObject(map);

        response.setContentType("application/json; charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.print(jsonObject);
        writer.close();
        response.flushBuffer();
        return false;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }



}
