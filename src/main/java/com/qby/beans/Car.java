package com.qby.beans;

import org.springframework.stereotype.Component;

/**
 * @author qby
 * @date 2020/6/9 20:12
 */
@Component
public class Car {
    public Car() {
        System.out.println("car构造器");
    }

    public void init() {
        System.out.println("car初始化");
    }
    public void destroy(){
        System.out.println("car销毁");
    }
}
