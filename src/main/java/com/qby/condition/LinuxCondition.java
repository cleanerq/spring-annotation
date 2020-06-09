package com.qby.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 判断是否linux系统
 *
 * @author qby
 * @date 2020/6/9 17:00
 */
public class LinuxCondition implements Condition {

    /**
     * 判断是否linux系统
     *
     * @param context 判断条件能使用的上下文环境
     * @param metadata 注释信息
     * @return
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // IOC容器使用的beanfactory
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        // 类加载器
        ClassLoader classLoader = context.getClassLoader();
        // 当前环境信息
        Environment environment = context.getEnvironment();
        // 获取bean定义的注册类
        BeanDefinitionRegistry registry = context.getRegistry();
        // 判断操作系统
        String property = environment.getProperty("os.name");


        if (property.contains("linux")) {
            return true;
        }

        return false;
    }
}
