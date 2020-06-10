package com.qby.config;

import com.qby.beans.Person;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import static org.junit.Assert.*;

/**
 * @author qby
 * @date 2020/6/10 12:58
 */
public class MainConfigOfPropertyValuesTest {

    AnnotationConfigApplicationContext applicationContext =
            new AnnotationConfigApplicationContext(MainConfigOfPropertyValues.class);

    private void printBeans(AnnotationConfigApplicationContext application) {
        String[] beanDefinitionNames = application.getBeanDefinitionNames();
        for (int i = 0; i < beanDefinitionNames.length; i++) {
            System.out.println(beanDefinitionNames[i]);
        }
    }

    @Test
    public void test01() {
        printBeans(applicationContext);

        Person bean = applicationContext.getBean(Person.class);
        System.out.println(bean);

        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String property = environment.getProperty("person.nickName");
        System.out.println(property);

        applicationContext.close();
    }


}