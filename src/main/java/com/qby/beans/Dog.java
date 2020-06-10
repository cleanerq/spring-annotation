package com.qby.beans;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author qby
 * @date 2020/6/9 23:08
 */
@Component
public class Dog {
    public Dog() {
        System.out.println("dog construct");
    }

    // 对象创建并赋值之后调用
    @PostConstruct
    public void init() {
        System.out.println("dog init @PostConstruct");
    }

    // 对象销毁之前调用
    @PreDestroy
    public void destroy() {
        System.out.println("dog destroy @PreDestroy");
    }
}
