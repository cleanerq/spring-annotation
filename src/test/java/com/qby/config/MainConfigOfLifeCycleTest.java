package com.qby.config;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

/**
 * @author qby
 * @date 2020/6/9 20:16
 */
public class MainConfigOfLifeCycleTest {

    @Test
    public void test01() {
        // 创建IOC容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        System.out.println("容器创建完成...");


//        Object bean = applicationContext.getBean("car");
        applicationContext.close();

    }

}