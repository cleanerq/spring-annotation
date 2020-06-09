package com.qby.config;


import com.qby.beans.Person;
import com.qby.condition.LinuxCondition;
import com.qby.condition.WindowCondition;
import com.qby.typefilter.MyTypeFilter;
import jdk.nashorn.internal.ir.ReturnNode;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

/**
 * @author qby
 * @date 2020/6/9 11:27
 */
// 类中组件统一设置 满足当前条件 这个类中的所有bean注册才能生效
@Conditional({WindowCondition.class})
@Configuration
public class MainConfig2 {

//    @Scope("prototype")
    @Bean("person")
    @Lazy
    public Person person01() {
        System.out.println("调用方法！");
        return new Person("张三", 25);
    }


    @Bean("bill")
    public Person person02() {
        return  new Person("bill gates", 62);
    }

    @Conditional({LinuxCondition.class})
    @Bean("linus")
    public Person person03() {
        return  new Person("linus", 48);
    }

}
