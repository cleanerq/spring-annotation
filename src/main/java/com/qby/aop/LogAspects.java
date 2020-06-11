package com.qby.aop;

import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 切面类
 * @Aspect 告诉spring容器当前类是一个切面类
 * @author qby
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
    public void pointCut(){};

    // 在目标方法之前切入，切入点表达式 在哪个方法切入
    // pointCut()
    @Before("com.qby.aop.LogAspects.pointCut()")
    public void logStart() {
        logger.info("除法运行。。。参数列表：{}");
    }

    //
    @After("pointCut()")
    public void logEnd() {
        logger.info("除法结束。。。");
    }

    @AfterReturning("pointCut()")
    public void logReturn() {
        logger.info("除法正常返回。。。运行结果：{}");
    }

    @AfterThrowing("pointCut()")
    public void logException() {
        logger.info("除法异常。。。异常信息:{}");
    }
}
