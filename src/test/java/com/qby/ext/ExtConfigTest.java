package com.qby.ext;

import com.qby.config.MainConfig;
import org.junit.Test;
import org.springframework.context.ApplicationEvent;
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
        // 发布事件
        application.publishEvent(new ApplicationEvent(new String("我发布的事件")) {
            });

        application.close();
    }
}