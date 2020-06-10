package com.qby.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author qby
 * @date 2020/6/10 17:30
 */
// 默认加在IOC容器中的组件 容器启动会调用无惨构造器 然后创建对象 在进行初始化和负责操作
@Component
public class Boss {

    private Car car;


    public Boss(Car car) {
        this.car = car;
        System.out.println("boss 有参构造器");
    }

    public Car getCar() {
        return car;
    }

    // 标注在方法 spring容器创建当前对象 就会调用方法完成赋值
    // 方法使用的参数，自定义的类型的值从IOC容器中获取
//    @Autowired
    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "car=" + car +
                '}';
    }
}
