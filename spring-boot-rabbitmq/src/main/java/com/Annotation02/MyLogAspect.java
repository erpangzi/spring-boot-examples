package com.Annotation02;

import com.rabbit.model.User;
import org.aspectj.lang.JoinPoint;
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
    public void Beforelog(JoinPoint joinPoint){
        System.out.println("Before ----"+joinPoint.getArgs());
    }
    @After("logPointCut()")
    public void Afterlog(JoinPoint joinPoint){
        System.out.println("After ----");
    }

    // 3. 环绕通知
    @Around("logPointCut()")
    public User logAround(ProceedingJoinPoint joinPoint){
        // 获取方法名称
        String methodName = joinPoint.getSignature().getName();
        // 获取入参
        Object[] param = joinPoint.getArgs();

        StringBuilder sb = new StringBuilder();
        for(Object o : param){
            sb.append(o + "; ");
        }
        System.out.println("进入[" + methodName + "]方法,参数为:" + sb.toString());

        User proceed = new User();
        // 继续执行方法
        try {
            proceed = (User)joinPoint.proceed();
            proceed.setName("1");
            proceed.setPass("1");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return proceed;

    }


    /**
     * 后置返回通知
     * 这里需要注意的是:
     * 如果参数中的第一个参数为JoinPoint，则第二个参数为返回值的信息
     * 如果参数中的第一个参数不为JoinPoint，则第一个参数为returning中对应的参数
     * returning 限定了只有目标方法返回值与通知方法相应参数类型时才能执行后置返回通知，否则不执行，对于returning对应的通知方法参数为Object类型将匹配任何目标返回值
     */
    @AfterReturning(value = "logPointCut()", returning = "keys")
    public void doAfterReturningAdvice1(JoinPoint joinPoint, Object keys) {
        System.out.println("第一个后置返回通知的返回值：" + keys);
        if (keys instanceof User) {
            User keys1 = (User) keys;
            keys1.setName("12");
            keys1.setPass("123");
        }
        System.out.println("修改完毕-->返回方法为:" + keys.toString());
    }

}
