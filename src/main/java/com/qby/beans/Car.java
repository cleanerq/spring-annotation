package com.qby.beans;

/**
 * @author qby
 * @date 2020/6/9 20:12
 */
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
