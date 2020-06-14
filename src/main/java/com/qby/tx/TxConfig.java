package com.qby.tx;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.beans.PropertyVetoException;

/**
 * 声明式事务
 * <p>
 * 环境搭建
 * 1、导入相关依赖
 * 数据源，数据库驱动，spring-jdbc模块
 * 2、配置数据源，JdbcTemplate（spring提供的简化数据库操作的工具）操作数据
 * 3、给方法标上@Transactional 表示当前方法是事物方法
 * 4、@EnableTransactionManagement 开启基于注解的事务管理功能
 *      @EnableXXX
 * 5、配置事务管理器来控制事务
 *      @Bean
 *     public PlatformTransactionManager transactionManager()
 *
 * 1 @EnableTransactionManagement 开启事务管理功能
 * 2 注册事务管理器在容器中 PlatformTransactionManager
 * 3 给方法标上@Transactional 表示当前方法是事物方法
 *
 * 原理：
 * 1）、@EnableTransactionManagement
 *      利用TransactionManagementConfigurationSelector.class给容器中会导入组件
 *      导入两个组件
 *          AutoProxyRegistrar.class
 * 			ProxyTransactionManagementConfiguration.class
 *
 * 2）、AutoProxyRegistrar
 *      给容器中 注册了一个 InfrastructureAdvisorAutoProxyCreator 组件
 *      InfrastructureAdvisorAutoProxyCreator
 *      利用后置处理器机制在对象创建以后，包装对象，返回一个代理对象（增强器），代理对象执行方法利用拦截器链进行调用
 *
 * 3）、ProxyTransactionManagementConfiguration
 *      1）、给容器中注册事务增强器
 *          1）、事务增强器要用事务注解的信息 AnnotationTransactionAttributeSource 解析事务注解
 *      2）、事务拦截器
 *          TransactionInterceptor 保存了事务属性信息 事务管理器
 *              它是一个 MethodInterceptor 方法拦截器
 *              在目标方法执行的时候：
 *              执行拦截器链：
 *                  事务拦截器
 *                      1）、先获取事务相关的属性
 *                      2）、再获取PlatformTransactionManager 事务管理器
 *                          如果事先没有添加指定任何 TransactionManager(注解里面指定)
 *                          最终会从容器中按照类型获取一个 PlatformTransactionManager
 *                      3）、执行目标方法
 *                          如果异常，获取到事物管理器，利用事务管理器回滚这次操作
 *                          如果正常，利用事务管理器提交事务
 *
 *
 * @author qby
 * @date 2020/6/12 18:40
 */

@EnableTransactionManagement
@ComponentScan(value = {"com.qby.tx"})
@Configuration
@PropertySource(value = {"classpath:/dbconfig.properties"})
public class TxConfig {

    @Value("${db.user}")
    private String user;

    @Value("${db.password}")
    private String password;

    @Value("${db.driverClass}")
    private String driverClass;

    @Value("${db.jdbc.url}")
    private String url;

    @Bean
    public DataSource dataSource() {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(password);
        dataSource.setJdbcUrl(url);
        try {
            dataSource.setDriverClass(driverClass);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        // spring对configuration类会特殊处理，
        // 给容器中加组件的方法，多次调用都只是从容器中找组件
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate;
    }

    /**
     * 注册事务管理器在容器中
     *
     * @return
     */
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }
}
