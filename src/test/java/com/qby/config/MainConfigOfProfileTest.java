package com.qby.config;

import com.qby.beans.Yellow;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

/**
 * @author qby
 * @date 2020/6/10 20:58
 */
public class MainConfigOfProfileTest {

    @Test
    public void test01() {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext();
        // 1.applicationContext
        applicationContext.getEnvironment().setActiveProfiles("test");
        applicationContext.register(MainConfigOfProfile.class);
        applicationContext.refresh();


        String[] beanNamesForType = applicationContext.getBeanNamesForType(DataSource.class);
        for (int i = 0; i < beanNamesForType.length; i++) {
            System.out.println(beanNamesForType[i]);
        }
        String[] beanNamesForType1 = applicationContext.getBeanNamesForType(Yellow.class);
        for (int i = 0; i < beanNamesForType1.length; i++) {
            System.out.println(beanNamesForType1[i]);
        }
        applicationContext.close();
    }
}