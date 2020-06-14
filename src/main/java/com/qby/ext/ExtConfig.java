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
 *      优先于 BeanFactoryPostProcessor 执行。
 *      利用 BeanDefinitionRegistryPostProcessor 给容器中再额外添加一些组件
 *
 *  原理：
 *      1）、IOC创建对象
 *      2）、refresh() -> invokeBeanFactoryPostProcessors(beanFactory);
 *      3）、先从容器中获取到所有的 BeanDefinitionRegistryPostProcessor 组件。
 *          1、依次触发所有的 postProcessBeanDefinitionRegistry 方法
 *          2、再来触发 postProcessBeanFactory 方法 BeanFactoryPostProcessor
 *      4）、再来从容器中找到 BeanFactoryPostProcessor 组件，然后依次触发 postProcessBeanFactory()方法
 *
 *  3、ApplicationListener ，监听容器中发布的事件，事件驱动模型开发
 *      public interface ApplicationListener<E extends ApplicationEvent> extends EventListener
 *          监听 ApplicationEvent 及其下面的子事件；
 *
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
