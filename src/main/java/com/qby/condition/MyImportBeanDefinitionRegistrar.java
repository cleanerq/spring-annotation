package com.qby.condition;

import com.qby.beans.RainBow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author qby
 * @date 2020/6/9 18:10
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {


    /**
     *
     * @param importingClassMetadata 当前类的注解信息
     * @param registry BeanDefinitionRegistry 注册类
     *                 把所有需要添加到容器中的bean
     *                 调用BeanDefinitionRegistry.registerBeanDefinition 手工注册
     *
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata,
                                        BeanDefinitionRegistry registry) {
        boolean red = registry.containsBeanDefinition("com.qby.beans.Red");
        boolean blue = registry.containsBeanDefinition("com.qby.beans.Blue");
        // 指定bean的注册信息 bean的scope
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(RainBow.class);

        if (red && blue) {
            // 指定类名 然后注册bean
            // 注册一个bean 指定bean名字
            registry.registerBeanDefinition("rainBow", rootBeanDefinition);
        }
    }
}
