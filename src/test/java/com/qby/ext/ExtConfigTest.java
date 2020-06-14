package com.qby.ext;

import com.qby.config.MainConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

/**
 * @author qby
 * @date 2020/6/13 23:59
 */
public class ExtConfigTest {

    @Test
    public void test01() {
        AnnotationConfigApplicationContext application
                = new AnnotationConfigApplicationContext(ExtConfig.class);


        application.close();
    }
}