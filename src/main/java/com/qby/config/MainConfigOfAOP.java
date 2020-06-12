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
 *              2）applyBeanPostProcessorsBeforeInitialization
 *                  应用后置处理器BeanPostProcessorsBeforeInitialization方法
 *              3）invokeInitMethods 执行自定义初始化方法
 *              4）applyBeanPostProcessorsAfterInitialization
 *                  执行后置处理器的BeanPostProcessorsAfterInitialization
 *          4）BeanPostprocessor(AnnotationAwareAspectJAutoProxyCreator)创建成功->aspectJAdvisorsBuilder
 *       7）、把BeanPostprocessor注册到BeanFactory中
 *          beanFactory.addBeanPostProcessor(postProcessor);
 * ========以上是创建和注册 AnnotationAwareAspectJAutoProxyCreator 的过程=======
 *      AnnotationAwareAspectJAutoProxyCreator => InstantiationAwareBeanPostProcessor 这种类型的后置处理器
 *  4）finishBeanFactoryInitialization(beanFactory);完成BeanFactory初始化工作，创建剩下的单实例bean
 *      1）、遍历获取容器中所有的bean，依次创建对象getBean(beanName)
 *          getBean(beanName)->doGetBean()->getSingleton
 *      2）、创建bean
 *          【AnnotationAwareAspectJAutoProxyCreator在所有bean创建之前会有一个拦截，
 *              InstantiationAwareBeanPostProcessor，会调用 postProcessBeforeInstantiation（）方法】
 *          1）、先从缓存中获取当前bean，如果能获取到，说明bean是之前被创建过的，直接使用，否则再创建；
 *              只要创建好的bean都会被缓存起来
 *          2）、createBean()，创建bean
 *              AnnotationAwareAspectJAutoProxyCreator会在任何bean创建之前尝试返回bean的实例
 *              【BeanPostProcessor是在bean对象创建完成初始化前后调用的】
 *              【InstantiationAwareBeanPostProcessor 是在创建bean实例之前先尝试用后置处理器返回对象】
 *              1）、resolveBeforeInstantiation(beanName, mbdToUse);解析BeforeInstantiation
 *                  希望后置处理器在此能返回一个代理对象，如能返回代理对象就是用，如果不能就继续 2）
 *                  1）、后置处理器先尝试返回对象：
 *                      bean = applyBeanPostProcessorsBeforeInstantiation(targetType, beanName);
 *                          拿到所有后置处理器，如果是 InstantiationAwareBeanPostProcessor；
 *                          就执行postProcessBeforeInstantiation
 *                      if (bean != null) {
 * 						    bean = applyBeanPostProcessorsAfterInitialization(bean, beanName);
 *                      }
 *              2）、doCreateBean(beanName, mbdToUse, args);真正的创建一个bean实例，和3.6流程一样
 *              3）、
 *
 * AnnotationAwareAspectJAutoProxyCreator【InstantiationAwareBeanPostProcessor】的作用，
 * 1）、每一个bean创建之前，调用 postProcessBeforeInstantiation（）
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
