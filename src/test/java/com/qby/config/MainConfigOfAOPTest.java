package com.qby.config;

import com.qby.aop.MathCalculator;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

/**
 * @author qby
 * @date 2020/6/11 11:13
 */
public class MainConfigOfAOPTest {
    
    @Test
    public void test01() {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(MainConfigOfAOP.class);

        MathCalculator mathCalculator = new MathCalculator();
        mathCalculator.div(1, 1);

        applicationContext.close();
    }

}