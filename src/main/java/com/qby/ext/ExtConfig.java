package com.qby.ext;

import com.qby.beans.Blue;
import com.qby.beans.Color;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

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
 *
 * 【监听器】
 *  3、ApplicationListener ，监听容器中发布的事件，事件驱动模型开发
 *      public interface ApplicationListener<E extends ApplicationEvent> extends EventListener
 *          监听 ApplicationEvent 及其下面的子事件；
 *
 *      步骤：
 *          1）、写一个监听器来监听某个事件(ApplicationEvent 及其子类) 实现 ApplicationListener<ApplicationEvent> 接口
 *              @EventListener 注解 任意方法都可以监听事件
 *              原理：使用 EventListenerMethodProcessor 处理器来解析方法上的 @EventListener 注解
 *
 *          2）、把监听器放入到容器中
 *          3）、只要容器中有相关事件的发布，我们就能监听到这个事件
 *              ContextRefreshedEvent 容器刷新完成（所有bean都完全创建）会发布这个事件
 *              ContextClosedEvent 关闭容器会发布这个事件
 *          4）、发布一个事件 application.publishEvent
 *  原理：
 *      ContextRefreshedEvent、ExtConfigTest$1[source=我发布的事件]、ContextClosedEvent
 *
 *  1）、ContextRefreshedEvent 事件：
 *      1）、容器创建对象，refresh()
 *      2）、finishRefresh() ，容器刷新完成 会发布 ContextRefreshedEvent 事件
 *  2）、自己发布事件 实现 ApplicationEvent 接口
 *  3）、容器关闭会发布 ContextClosedEvent
 *      【事件发布流程：】
 *      3）、publishEvent(new ContextRefreshedEvent(this));
 *              1）、获取事件的多播器（派发器）：getApplicationEventMulticaster()
 *              2）、multicastEvent()派发事件：
 *              3)、获取到所有的 ApplicationListeners
 *                  for (ApplicationListener<?> listener : getApplicationListeners(event, type))
 *                  1）、如果有 Executor 可以支持使用 Executor 进行异步派发
 *                  2）、否则，同步的方式执行 invokeListener(listener, event) 方法
 *                      拿到listener 回调 onApplicationEvent 方法
 *      【事件多播器（事件派发器）】
 *      1）、容器创建对象：refresh()
 *      2）、initApplicationEventMulticaster() 初始化 ApplicationEventMulticaster
 *          1）、先去容器中找有没有ID = "applicationEventMulticaster" 的组件
 *          2）、如果没有 this.applicationEventMulticaster = new SimpleApplicationEventMulticaster(beanFactory);
 *              并且加入到容器中，我们就可以在其他组件要派发事件，自动注入这个 applicationEventMulticaster
 *
 *      【容器中有哪些监听器】
 *      1）、容器创建对象：refresh()
 *      2）、registerListeners();
 *          从容器中拿到所有的监听器 把他们注册到 applicationEventMulticaster 中
 *          String[] listenerBeanNames = getBeanNamesForType(ApplicationListener.class, true, false);
 *          将listener 注册到 ApplicationEventMulticaster 中
 *          getApplicationEventMulticaster().addApplicationListenerBean(listenerBeanName);
 *
 *      SmartInitializingSingleton 接口原理 -> afterSingletonsInstantiated()
 *          1）、IOC容器创建对象 并refresh()
 *          2）、finishBeanFactoryInitialization(beanFactory); 初始化剩下的单实例bean
 *              1）、先创建所有的单实例bean getBean()方法创建bean
 *              2）、获取所有创建好的单实例bean 判断是否是 SmartInitializingSingleton 类型接口
 *                  如果是就调用 afterSingletonsInstantiated() 方法
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
