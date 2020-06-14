package com.qby.ext;

import com.qby.beans.Blue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * 扩展原理
 * BeanPostProcessor bean的后置处理 bean创建对象初始化前后进行拦截工作的
 * BeanFactoryPostProcessor beanFactory的后置处理器
 *      在BeanFactory标准初始化之后调用 所有的bean定义已经保存加载到BeanFactory中 但是bean的实例还没创建
 *
 * 1)、IOC容器创建对象
 * 2）、invokeBeanFactoryPostProcessors(beanFactory); 执行 BeanFactoryPostProcessor
 *      如何找到所有的 BeanFactoryPostProcessor 并执行他们的方法
 *      1）、直接在BeanFactory中找到所有类型是BeanFactoryPostProcessor的组件，并执行他们的方法
 *      2)、在初始化创建其他组件前面执行
 * 2、BeanDefinitionRegistryPostProcessor extends BeanFactoryPostProcessor
 *      postProcessBeanDefinitionRegistry（）;
 *      在所有bean定义信息将要被加载，bean实例还未创建时执行
 *
 * @author qby
 * @date 2020/6/13 18:57
 */
@ComponentScan(value = {"com.qby.ext"})
@Configuration
public class ExtConfig {

    @Bean
    public Blue blue() {
        return new Blue();
    }
}
