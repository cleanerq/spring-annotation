package com.qby.config;

import com.qby.beans.Boss;
import com.qby.beans.Car;
import com.qby.beans.Color;
import com.qby.dao.BookDao;
import com.qby.service.BookService;
import org.junit.Test;
import org.springframework.beans.CachedIntrospectionResults;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

/**
 * @author qby
 * @date 2020/6/10 15:13
 */
public class MainConfigOfAutowiredTest {
    private AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);


    @Test
    public void test01() {
//        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
//        for (int i = 0; i < beanDefinitionNames.length; i++) {
//            System.out.println(beanDefinitionNames[i]);
//        }


        BookService bookService = applicationContext.getBean(BookService.class);
        System.out.println(bookService);


//        BookDao bean =  applicationContext.getBean(BookDao.class);
//        System.out.println(bean);

        Boss bean = applicationContext.getBean(Boss.class);
        System.out.println(bean);

        Car bean1 = applicationContext.getBean(Car.class);
        System.out.println(bean1);

        Color bean2 = applicationContext.getBean(Color.class);
        System.out.println(bean2);
        System.out.println(applicationContext);
        applicationContext.close();
    }

}