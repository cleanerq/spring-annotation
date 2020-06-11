package com.qby.config;


import com.qby.beans.Person;
import com.qby.dao.BookDao;
import com.qby.service.BookService;
import com.qby.typefilter.MyTypeFilter;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;

/**
 * @author qby
 * @date 2020/6/9 11:27
 */
@Configuration
@ComponentScans(value = {@ComponentScan(value = "com.qby",
        includeFilters = {
            @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class}),
            @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {BookService.class}),
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {BookDao.class}),
            @ComponentScan.Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})},
        useDefaultFilters = false)})
public class MainConfig {

    @Bean("person")
    public Person person01() {
        return new Person("lisi", 30);
    }

}
