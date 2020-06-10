package com.qby.config;

import com.qby.beans.Car;
import com.qby.beans.Color;
import com.qby.dao.BookDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * 自动装配：
 * spring利用依赖注入(DI) 完成对IOC容器中各个组件的依赖关系赋值
 *
 * @author qby
 * @date 2020/6/10 15:05
 */
@Configuration
@ComponentScan(value = {"com.qby.service",
        "com.qby.dao",
        "com.qby.controller",
        "com.qby.beans"})
public class MainConfigOfAutowired {

    @Primary
    @Bean("bookDao2")
    public BookDao bookDao() {
        BookDao bookDao = new BookDao();
        bookDao.setLable("2");
        return bookDao;
    }

    /**
     * @bean标注的方法创建对象的时候，方法参数的值从容器中获取
     *
     * @param car
     * @return
     */
    @Bean
    public Color color(Car car) {
        Color color = new Color();
        color.setCar(car);
        return color;
    }
}
