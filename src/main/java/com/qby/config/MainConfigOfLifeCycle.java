package com.qby.config;

import com.qby.beans.Car;
import org.springframework.context.annotation.*;

/**
 * bean的生命周期
 *  bean创建-初始化-销毁的过程
 *  容器管理bean的生命周期
 * 我们可以自定义初始化和销毁方法 容器在bean进行到
 * 当前生命周期的时候来调用我们自定义的初始化和销毁方法
 *
 * @author qby
 * @date 2020/6/9 20:08
 */
//@ComponentScan(value = "com.qby.beans")
@Configuration
public class MainConfigOfLifeCycle {

//    @Scope(value = "prototype")
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Car car() {
        return new Car();
    }
}
