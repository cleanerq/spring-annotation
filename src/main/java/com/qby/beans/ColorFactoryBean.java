package com.qby.beans;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author qby
 * @date 2020/6/9 19:48
 */
// 创建一个spring定义的FactoryBean
public class ColorFactoryBean implements FactoryBean<Color> {
    // 返回Color对象 这个对象会添加到容器中
    @Override
    public Color getObject() throws Exception {
        return new Color();
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

    /**
     * 是否单例
     * true 单例 在容器中保留一份
     * false 非单例 每次获取都会创建一个新的Bean
     * @return
     */
    @Override
    public boolean isSingleton() {
        return true;
//        return false;
    }
}
