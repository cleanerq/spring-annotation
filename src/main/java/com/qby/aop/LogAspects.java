package com.qby.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * 切面类
 *
 * @author qby
 * @Aspect 告诉spring容器当前类是一个切面类
 * @date 2020/6/11 9:21
 */
@Aspect
public class LogAspects {

    private static Logger logger = LoggerFactory.getLogger(LogAspects.class);

    /**
     * 1、本类引用
     * 2、其他的切面引用
     */
    @Pointcut("execution(public int com.qby.aop.MathCalculator.*(..))")
    public void pointCut() {
    }

    ;

    // 在目标方法之前切入，切入点表达式 在哪个方法切入
    // pointCut()
    @Before("com.qby.aop.LogAspects.pointCut()")
    public void logStart(JoinPoint joinPoint) {
        // 方法名称
        String name = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        logger.info("{} 除法运行。。。@Before 参数列表：{}", name, Arrays.asList(args));
    }

    //
    @After("pointCut()")
    public void logEnd(JoinPoint joinPoint) {
        // 方法名称
        String name = joinPoint.getSignature().getName();
        logger.info("{} 除法结束。。。@After", name);
    }

    /**
     * joinpoint 必须出现在参数表的第一个
     *
     * @param joinPoint
     * @param result
     */
    @AfterReturning(value = "pointCut()", returning = "result")
    public void logReturn(JoinPoint joinPoint, Object result) {
        // 方法名称
        String name = joinPoint.getSignature().getName();
        logger.info("{} 除法正常返回。。。@AfterReturning 运行结果：{}", name, result);
    }

    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void logException(JoinPoint joinPoint, Exception exception) {
        // 方法名称
        String name = joinPoint.getSignature().getName();
        logger.info("{} 除法异常。。。@AfterThrowing 异常信息:{}", name, exception.toString());
    }
}
