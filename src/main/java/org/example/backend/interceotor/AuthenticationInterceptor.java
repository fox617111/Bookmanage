package org.example.backend.interceotor;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.InvalidClaimException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import org.example.backend.utils.JwtUtil;
import org.example.backend.utils.ThreadLocalUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.HashMap;
import java.util.Map;

@Component
public class AuthenticationInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                             Object object) throws Exception {

        // 实际这个名字可以指定为别的，token太没有辨识度---
        // 这个header是在创建完token返回给前端时指定的头部的key，value就是token内容
        String token = httpServletRequest.getHeader("Authorization");
        Map<String, Object> map = new HashMap<>();
        try {
            // 这里尽行token验证，捕获异常，正常的话也不需要处理，直接抛出异常，由统一异常处理类进行处理，然后返回给前端统一数据类型。
            map = JwtUtil.parseToken(token);
            ThreadLocalUtil.set(map);
            return true;
        } catch (SignatureVerificationException e) {
            e.printStackTrace();
            map.put("msg", "签名不一致");
            map.put("code", 401);
        } catch (TokenExpiredException e) {
            e.printStackTrace();
            map.put("msg", "令牌过期");
            map.put("code", 401);
        } catch (AlgorithmMismatchException e) {
            e.printStackTrace();
            map.put("msg", "算法不匹配");
            map.put("code", 401);
        } catch (InvalidClaimException e) {
            e.printStackTrace();
            map.put("msg", "失效的payload");
            map.put("code", 401);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg", "token无效");
            map.put("code", 401);
        }
        // 根据自己所需选择所需的异常处理
        map.put("state", false);
        // 响应到前台: 将map转为json
        String json = new ObjectMapper().writeValueAsString(map);
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        httpServletResponse.getWriter().println(json);
        return false;
    }
}
