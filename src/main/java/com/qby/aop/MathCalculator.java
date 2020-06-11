package com.qby.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author qby
 * @date 2020/6/11 9:19
 */
public class MathCalculator {
    private static Logger logger = LoggerFactory.getLogger(MathCalculator.class);

    public int div(int i, int j) {
        logger.info("MathCalculator...=>div()");
        return i / j;
    }
}
