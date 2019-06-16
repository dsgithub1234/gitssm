package com.itheima.conterller;

import com.itheima.SysLog;
import com.itheima.service.SysLogService;
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

    @Autowired
    private SysLogService sysLogService;

    @Autowired
    private HttpServletRequest request;

    private Date startTime;//执行时间
    private Class clazz;//访问的类
    private Method method;//访问的方法
    private String methodName;

    //前置通知
    @Before("execution(* com.itheima.conterller.*.*(..))")
    public void before(JoinPoint jp) throws NoSuchMethodException {
        //获取时间
       startTime=new Date();
        //获取访问的类
       clazz = jp.getTarget().getClass();

        //获取访问的方法名称
        methodName = jp.getSignature().getName();
        //获取方法类的参数
        Object[] args = jp.getArgs();
        if(args!=null){
            method = clazz.getMethod(methodName);
        }else {
            //获取访问的方法的参数
            Class[]classes=new Class[args.length];
            for (int i = 0; i < classes.length; i++) {
                classes[i]=args[i].getClass();
            }
         method=  clazz.getMethod(methodName,classes);
        }

    }
        //获取方法



    @After("execution(* com.itheima.conterller.*.*(..))")
    public void after(JoinPoint jp){

        //获取访问的时长
     Long time= new Date().getTime()- startTime.getTime();
        String url="";
       //获取访问的url
     if(this.clazz !=null&&method!=null&& this.clazz !=LogAop.class){

         //获取类上的RequsetMapping的对象
         RequestMapping requestMapping = (RequestMapping) this.clazz.getAnnotation(RequestMapping.class);
         if(requestMapping!=null){
             String[] classRequestMapping = requestMapping.value();

             //获取方法上的RequsetMapping的对象
          RequestMapping methodRequestMapping = method.getAnnotation(RequestMapping.class);
            if(methodRequestMapping!=null){
               String[] methodMapping = methodRequestMapping.value();
                 url=classRequestMapping[0]+methodMapping[0];
             }
         }
     }

           //获取ip
        String ip = request.getRemoteAddr();

          //获取操作者
        SecurityContext context = SecurityContextHolder.getContext();
        User user = (User) context.getAuthentication().getPrincipal();
        String username = user.getUsername();
        //将得到的数据封装到对象中
        SysLog sysLog=new SysLog();
        sysLog.setVisitTime(new Date());
        sysLog.setUsername(username);
        sysLog.setExecutionTime(time);
        sysLog.setIp(ip);
        sysLog.setUrl(url);
        sysLog.setMethod("[类名]"+ this.clazz.getName()+"[方法名]"+method.getName());

        //将数据保存到数据库中
        sysLogService.save(sysLog);

    }

}
