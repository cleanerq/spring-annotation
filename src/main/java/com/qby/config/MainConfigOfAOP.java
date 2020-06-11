package com.qby.config;

import com.qby.aop.LogAspects;
import com.qby.aop.MathCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author qby
 * @date 2020/6/11 9:14
 *
 * 1.导入aop模块 springAOP
 * 2.定义一个业务逻辑 MathCalculator 在业务逻辑运行的时候将日志打印
 * 3.定义一个日志切面类LogAspects 切面类里面的方法需要动态感知MathCalculator.div方法
 *      通知方法：
 *          前置通知：(@Before) logStart 在目标方法div运行之前运行
 *          后置通知：(@After) logEnd 在目标方法div运行之后运行（无论方法正常结束还是异常结束）
 *          返回通知：(@AfterReturning) logReturn 在目标方法div正常返回之后运行
 *          异常通知：(@AfterThrowing) logException 在目标方法div出现异常后运行
 *          环绕通知：(@Around) 动态代理 手头推进目标方法运行 joinPoint.proceed()
 * 4.给切面类的目标方法标注何时运行(通知注解)
 * 5.将切面类和业务逻辑类(目标方法所在类)都加入到容器中
 * 6.必须告诉spring容器哪个类是切面类给切面类增加注解@Aspect
 * 7.给配置类增加@EnableAspectJAutoProxy 注解 开启基于注解的apo模式
 *  在spring中很多的@EnableXXX
 *
 * 原理调用流程：
 *  1）、传入配置类，创建IOC容器
 *  2）、注册配置类，调用refresh（）刷新容器
 *  3）、registerBeanPostProcessors(beanFactory);注册bean的后置处理器来方便拦截bean的创建
 *      1）、先获取IOC容器已经定义了的需要创建对象的所有BeanPostProcessor
 *      2）、给容器中加了别的BeanPostProcessor
 *      3）、优先注册实现了PriorityOrdered接口的BeanPostProcessor
 *      4）、再给容器中注册了实现了Ordered接口的BeanPostProcessor
 *      5）、注册没实现优先级接口的BeanPostProcessor
 *      6）、注册BeanPostProcessor，实际上就是创建BeanPostProcessor对象，保存到容器中，
 *          创建org.springframework.aop.config.internalAutoProxyCreator的BeanPostProcessor
 *          【AnnotationAwareAspectJAutoProxyCreator】
 *          1）创建bean实例
 *          2）populateBean给bean的各种属性赋值
 *          3）initializeBean 初始化bean
 *              1）invokeAwareMethods 处理aware接口的方法回调
 *              2）applyBeanPostProcessorsBeforeInitialization 应用后置处理器BeanPostProcessorsBeforeInitialization方法
 *              3）invokeInitMethods 执行自定义初始化方法
 *              4）applyBeanPostProcessorsAfterInitialization 执行后置处理器的BeanPostProcessorsAfterInitialization
 *          4）BeanPostprocessor(AnnotationAwareAspectJAutoProxyCreator)创建成功->aspectJAdvisorsBuilder
 *       7）、把BeanPostprocessor注册到BeanFactory中
 *          beanFactory.addBeanPostProcessor(postProcessor);
 * ========以上是创建AnnotationAwareAspectJAutoProxyCreator的过程=======
 *
 */
@EnableAspectJAutoProxy
@Configuration
public class MainConfigOfAOP {

    // 业务逻辑类加入到容器中
    @Bean
    public MathCalculator calculator() {
        return new MathCalculator();
    }

    @Bean
    public LogAspects logAspects() {
        return new LogAspects();
    }
}
