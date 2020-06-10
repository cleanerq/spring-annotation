package com.qby.config;

import com.qby.dao.BookDao;
import com.qby.service.BookService;
import org.junit.Test;
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

        applicationContext.close();
    }

}