package com.qby.ext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * @author qby
 * @date 2020/6/14 14:31
 */
@Service
public class UserService {
    Logger logger = LoggerFactory.getLogger(getClass());


    @EventListener(classes = {ApplicationEvent.class})
    public void listen(ApplicationEvent event) {
        logger.info("UserService 监听到的事件{}", event);
    }
}
