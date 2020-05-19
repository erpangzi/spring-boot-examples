package com.Annotation02;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect // 1.表明这是一个切面类
@Component
public class MyLogAspect {

    // 2. PointCut表示这是一个切点，@annotation表示这个切点切到一个注解上，后面带该注解的全类名
    // 切面最主要的就是切点，所有的故事都围绕切点发生
    // logPointCut()代表切点名称
    @Pointcut("@annotation(com.Annotation02.MyLog)")
    public void logPointCut(){};

    @Before("logPointCut()")
    public void Beforelog(){
        System.out.println("Before ----");
    }
    @After("logPointCut()")
    public void Afterlog(){
        System.out.println("Before ----");
    }

    // 3. 环绕通知
    @Around("logPointCut()")
    public String logAround(ProceedingJoinPoint joinPoint){
        // 获取方法名称
        String methodName = joinPoint.getSignature().getName();
        // 获取入参
        Object[] param = joinPoint.getArgs();

        StringBuilder sb = new StringBuilder();
        for(Object o : param){
            sb.append(o + "; ");
        }
        System.out.println("进入[" + methodName + "]方法,参数为:" + sb.toString());

        String proceed = "";
        // 继续执行方法
        try {
            proceed = (String)joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return proceed;

    }
}