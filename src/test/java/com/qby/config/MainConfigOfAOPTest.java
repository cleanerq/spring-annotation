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
        // 不要自己创建对象
//        MathCalculator mathCalculator = new MathCalculator();
//        mathCalculator.div(1, 1);
        // 要从spring容器中取得
        try {
            MathCalculator bean = applicationContext.getBean(MathCalculator.class);
            bean.div(1, 0);

        } catch (Exception e) {

        }

        applicationContext.close();
    }

}