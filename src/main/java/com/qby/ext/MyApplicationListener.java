package com.qby.ext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author qby
 * @date 2020/6/14 13:28
 */
public class MyApplicationListener implements ApplicationListener<ApplicationEvent> {
    Logger logger = LoggerFactory.getLogger(getClass());

    // 当容器中发布此事件以后，方法触发
    @Override
    public void onApplicationEvent(ApplicationEvent event) {

    }
}
