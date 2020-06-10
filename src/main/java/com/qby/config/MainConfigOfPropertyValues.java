package com.qby.config;

import com.qby.beans.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author qby
 * @date 2020/6/10 12:57
 */

@PropertySource(value = {"classpath:/person.properties"})
@Configuration
public class MainConfigOfPropertyValues {

    @Bean
    public Person person() {
        return new Person();
    }
}
