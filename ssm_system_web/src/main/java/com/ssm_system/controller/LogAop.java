package com.ssm_system.controller;

import com.ssm_system.domain.Syslog;
import com.ssm_system.service.ISysLogService;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

@Component
@Aspect
public class LogAop {
    //创建一个访问日志的切面类，交给spring管理

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ISysLogService sysLogService;

    private Date visitTime = new Date(); //开始时间
    private Class clazz; //访问的类
    private Method method;//访问的方法

    //前置通知  主要是获取开始时间，执行的类是哪一个，执行的是哪一个方法  JoinPoint程序执行过程中明确的点
    @Before("execution(* com.ssm_system.controller.*.*(..))")
    public void doBefore(JoinPoint jp) throws NoSuchMethodException {

        clazz = jp.getTarget().getClass(); //具体要访问的类
        String methodName = jp.getSignature().getName(); //获取访问的方法的名称
        Object[] args = jp.getArgs();//获取访问的方法的参数

        //获取具体执行的方法的Method对象
        if (args == null || args.length == 0) {
            method = clazz.getMethod(methodName); //只能获取无参数的方法
        } else {
            Class[] classArgs = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                classArgs[i] = args[i].getClass();
            }
            //methodName方法名  classArgs参数名
            method = clazz.getMethod(methodName, classArgs);
        }
    }

    //后置通知
    @After("execution(* com.ssm_system.controller.*.*(..))")
    public void doAfter(JoinPoint jp) throws Exception {
        long time = new Date().getTime() - visitTime.getTime(); //获取访问的时长

        String url = "";
        //获取url
        if (clazz != null && method != null && clazz != LogAop.class) {
            //1.获取类上的@RequestMapping("/orders")
            RequestMapping classAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
            if (classAnnotation != null) {
                String[] classValue = classAnnotation.value();
                //2.获取方法上的@RequestMapping(xxx)
                RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
                if (methodAnnotation != null) {
                    String[] methodValue = methodAnnotation.value();
                    url = classValue[0] + methodValue[0];

                    //获取访问的ip
                    String ip = request.getRemoteAddr();
                    ip=ip.equals("0:0:0:0:0:0:0:1")?"127.0.0.1":ip;

                    //获取当前操作的用户
                    SecurityContext context = SecurityContextHolder.getContext();//从上下文中获了当前登录的用户
                    User user = (User) context.getAuthentication().getPrincipal();
                    String username = user.getUsername();

                    //将日志相关信息封装到SysLog对象
                    Syslog syslog = new Syslog();
                    syslog.setExecutionTime(time); //执行时长
                    syslog.setIp(ip);
                    syslog.setMethod("[类名] " + clazz.getName() + "[方法名] " + method.getName());
                    syslog.setUrl(url);
                    syslog.setUsername(username);
                    syslog.setVisitTime(visitTime);


                    //调用Service完成操作
                    sysLogService.save(syslog);
                }
            }
        }

    }
}