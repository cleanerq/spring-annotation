package com.qby.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author qby
 * @date 2020/6/9 18:03
 */
public class Blue {
    Logger logger = LoggerFactory.getLogger(getClass());
    public Blue() {
        logger.info("blue.....constructor");
    }

    public void init() {
        logger.info("blue.....init");
    }

    public void destroy() {
        logger.info("blue.....destroy");
    }
}
