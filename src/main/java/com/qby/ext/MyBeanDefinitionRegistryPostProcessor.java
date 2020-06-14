package com.qby.ext;

import com.qby.beans.Blue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.*;
import org.springframework.stereotype.Component;

/**
 * @author qby
 * @date 2020/6/14 0:18
 */
@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    Logger logger = LoggerFactory.getLogger(getClass());


    /**
     *
     * @param registry bean定义信息的保存中心，
     *                 以后BeanFactory就是按照BeanDefinitionRegistry里面保存的
     *                 每一个bean定义信息创建bean实例
     * @throws BeansException
     */
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        logger.info("postProcessBeanDefinitionRegistry....bean的数量:{}", registry.getBeanDefinitionCount());

//        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Blue.class);
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.rootBeanDefinition(Blue.class).getBeanDefinition();
        registry.registerBeanDefinition("hello", beanDefinition);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        logger.info("postProcessBeanFactory...bean的数量:{}", beanFactory.getBeanDefinitionCount());
    }
}
