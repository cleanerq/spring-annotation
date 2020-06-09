package com.qby.config;

import com.qby.beans.Blue;
import com.qby.beans.Person;
import org.junit.Test;
import org.junit.internal.builders.JUnit3Builder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import sun.applet.Main;

import java.util.Map;
import java.util.Set;

/**
 * @author qby
 * @date 2020/6/9 13:21
 */
public class MainConfigTest {
    AnnotationConfigApplicationContext application = new AnnotationConfigApplicationContext(MainConfig2.class);

    @Test
    public void test01() {
        AnnotationConfigApplicationContext application = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] beanDefinitionNames = application.getBeanDefinitionNames();
        for (int i = 0; i < beanDefinitionNames.length; i++) {
            System.out.println(beanDefinitionNames[i]);
        }
    }

    @Test
    public void test02() {
        AnnotationConfigApplicationContext application = new AnnotationConfigApplicationContext(MainConfig2.class);
        String[] beanDefinitionNames = application.getBeanDefinitionNames();
        for (int i = 0; i < beanDefinitionNames.length; i++) {
            System.out.println(beanDefinitionNames[i]);
        }
        Object person = application.getBean("person");
        Object person2 = application.getBean("person");
        System.out.println(person == person2);
    }

    @Test
    public void test03() {
        String[] beanDefinitionNames = application.getBeanDefinitionNames();
        ConfigurableEnvironment environment = application.getEnvironment();
        for (int i = 0; i < beanDefinitionNames.length; i++) {
            System.out.println(beanDefinitionNames[i]);
        }

        System.out.println("当前系统：" + environment.getProperty("os.name"));
        Map<String, Person> beansOfType = application.getBeansOfType(Person.class);
        System.out.println(beansOfType);
    }

    @Test
    public void testImport() {
        printBeans(this.application);

        Blue bean = application.getBean(Blue.class);
        System.out.println(bean);

        // 工厂bean获取的是调用getObject创建的对象
        Object colorFactoryBean1 = application.getBean("colorFactoryBean");
        Object colorFactoryBean2 = application.getBean("colorFactoryBean");
        System.out.println(colorFactoryBean1.getClass());
        System.out.println(colorFactoryBean1 == colorFactoryBean2);

        Object colorFactoryBean3 = application.getBean("&colorFactoryBean");
        System.out.println(colorFactoryBean3);
    }

    private void printBeans(AnnotationConfigApplicationContext application) {
        String[] beanDefinitionNames = application.getBeanDefinitionNames();
        for (int i = 0; i < beanDefinitionNames.length; i++) {
            System.out.println(beanDefinitionNames[i]);
        }
    }


}