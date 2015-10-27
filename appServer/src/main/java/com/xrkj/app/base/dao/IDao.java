/**
 * Copyright(C) 2015-2025 杏仁科技
 * All rights reserved
 * 2015年6月25日 Created
 */
package com.xrkj.app.base.dao;

/**
 * <pre>
 * 基础的数据访问接口
 * </pre>
 *
 * @author wwh
 * @date 2015年6月25日 下午6:59:23
 *
 */
public interface IDao {
    // 为了代替手工使用 SqlSessionDaoSupport 或 SqlSessionTemplate 编写数据访问对象
    // (DAO)的代码,MyBatis-Spring 提供了一个动态代理的实现:MapperFactoryBean
    /**
     * <code>
     * <bean id="userMapper" class="org.mybatis.spring.mapper.MapperFactoryBean">
     *     <property name="mapperInterface" value="org.mybatis.spring.sample.mapper.UserMapper" />
     *     <property name="sqlSessionFactory" ref="sqlSessionFactory" />
     * </bean>
     * </code>
     */

    // 使用MapperScannerConfigurer,它将会查找类路径下的映射器并自动将它们创建成
    // MapperFactoryBean。
    /**
     * <code>
     * <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
     *     <property name="basePackage" value="org.mybatis.spring.sample.mapper" />
     * </bean>
     * </code>
     */
    // 使用 @Component 或 JSR-330 的@Named 注解,来设置bean名称

    // 用于定义常量，接口等
    // 如果需要统一的方法可以在这里定义
    // 但是由于生成的对象都是自动代理的，应该需要使用Spring 的AOP功能，通过切面拦截方法，可以使用 自定义的注解 标记需要拦截的方法
}
