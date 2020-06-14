package com.qby.ext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author qby
 * @date 2020/6/13 23:53
 */
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        logger.info("MyBeanFactoryPostProcessor.....postProcessBeanFactory");
        int beanDefinitionCount = beanFactory.getBeanDefinitionCount();
        logger.info("当前 BeanFactory 中有{}个bean", beanDefinitionCount);

        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        logger.info(Arrays.asList(beanDefinitionNames).toString());


    }
}
