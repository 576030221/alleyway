package com.alleyway.component;


import com.alibaba.fastjson.JSON;
import com.alleyway.utils.Result;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * save方法验证登录状态
 * 若无登录..返回code 3
 */
@Aspect    // 定义为切片
@Component  // 加入容器
public class LoginAspect {
    // 用于存储post delete put请求中 不需要拦截的方法
    private static List<String> nameList = new LinkedList<>();
    static {
        // 插入post delete put 请求中不需要拦截的方法名
        nameList.add("login");
        nameList.add("loginEncryption");
        nameList.add("register");
        nameList.add("getPhoneVerify");
    }

    /**
     * 拦截增删改操作
     *
     */
//    @Around("execution(* save* (..)) || execution(* delete* (..)) || execution(* alter* (..))")          // 切入点  切点为所有方法名以save开头的方法。  是方法名，而不是@GetMapping的名字
//    @Around("execution(* com.alleyway.controller.*.*(..))")			// 拦截controller包下的所有方法的所有请求
    @Around("@annotation(org.springframework.web.bind.annotation.DeleteMapping)" +
	  "||@annotation(org.springframework.web.bind.annotation.PostMapping)" +
	  "||@annotation(org.springframework.web.bind.annotation.PutMapping)"
    )	// 拦截这三种请求方式
    public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable {          // pjp就是你要调用的一些数据，比如你要调用的类，要调用的方法名，参数等

        // 获取需要调用的方法名
        String methodName = pjp.getSignature().getName();
        // 判断方法名是否未无需拦截的，如果是，直接放行
        if (nameList.contains(methodName)) {
	  Object object = pjp.proceed();          // 先去执行真正想调用的方法 ，得到那个方法返回的东西
	  return object;
        }

        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = attributes.getResponse();
        HttpServletRequest request = attributes.getRequest();
        // 获取session
        HttpSession session = request.getSession();
        // 判断这个session是否登录过
        String status = (String) session.getAttribute("status");
        if (status != null) {
            // 用户登录过
            Object object = pjp.proceed();          // 先去执行真正想调用的方法 ，得到那个方法返回的东西
            return object;
        }
        request.setCharacterEncoding("UTF-8");
        Result result = Result.failure(3);
        response.getWriter().write(JSON.toJSONString(result));
        return null;
    }


}
