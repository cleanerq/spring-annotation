package com.qby.main;

import com.qby.beans.Person;
import com.qby.config.MainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.annotation.Annotation;

/**
 * @author qby
 * @date 2020/6/9 12:40
 */
public class TestMain {

    public static void main(String[] args) {
//        ApplicationContext applicationContext =new ClassPathXmlApplicationContext("ddd");

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);

        Person bean = applicationContext.getBean(Person.class);
        System.out.println(bean);

        String[] beanNamesForAnnotation = applicationContext.getBeanNamesForType(Person.class);

        for (int i = 0; i < beanNamesForAnnotation.length; i++) {
            System.out.println(beanNamesForAnnotation[i]);
        }
    }

}
