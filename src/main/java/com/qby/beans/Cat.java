package com.qby.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author qby
 * @date 2020/6/9 22:57
 */
@Component
public class Cat implements InitializingBean, DisposableBean {
    public Cat() {
        System.out.println("cat constructor...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("cat destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        // 在bean创建完成并初始化后调用
        System.out.println("cat afterPropertiesSet");
    }
}
