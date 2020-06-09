package com.qby.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 判断是否windows系统
 * @author qby
 * @date 2020/6/9 17:00
 */
public class WindowCondition implements Condition {
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
        // 可以判断容器中bean注册情况 也可以给容器中注册bean
        boolean person = registry.containsBeanDefinition("person");
        if (person) {
            return true;
        }
        if (property.contains("Windows")) {
            return true;
        }

        return false;
    }
}
