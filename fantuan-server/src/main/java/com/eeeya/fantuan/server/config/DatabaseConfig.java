package com.eeeya.fantuan.server.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Driver;

/**
 * @author zhonghui
 * @since 5/8/15.
 */
@Configuration
@MapperScan(basePackages="com.eeeya.fantuan.server.mapper")
public class DatabaseConfig {

    @Bean
    public DataSource getDataSource() throws PropertyVetoException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setPreferredTestQuery("SELECT 1");
        comboPooledDataSource.setMaxIdleTime(60);
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://daidaiduoduo.com:3306/fantuan?useUnicode=true&amp;characterEncoding=utf8");
        comboPooledDataSource.setUser("fantuan");
        comboPooledDataSource.setPassword("fantuan");
        comboPooledDataSource.setDriverClass(Driver.class.getName());
        return comboPooledDataSource;
    }

    @Bean
    public SqlSessionFactory getSqlSessionFactory(DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        return sessionFactory.getObject();
    }
}