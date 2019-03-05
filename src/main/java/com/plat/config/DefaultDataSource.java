package com.plat.config;

import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * 数据源加载
 * @author chenrong
 *
 */
@Configuration
// 数据源映射的dao
@MapperScan(basePackages = "com.plat.dao",
            sqlSessionFactoryRef = DefaultDataSource.SQL_SESSION_FACTORY_NAME)
@EnableTransactionManagement
public class DefaultDataSource {
	// 定义默认的数据源sessionFactory
	public static final String SQL_SESSION_FACTORY_NAME = "mysqlSessionFactory";
	// 定义加载的mybatis配置文件  mybatis配置文件必须以Mapper结尾的xml文件
	static final String LOCAL_MAPPER = "classpath:defaultMapper/*Mapper.xml";
	// 定义加载的bean包
	static final String TYPE_ALIASES_PACKAGE = "com.plat.bean";
	
	/**
	 * 初始化数据源
	 * @param dbConfig
	 * @return
	 */
	@Bean(name = "mysqlDataSource", initMethod = "init", destroyMethod = "close")
	@Primary
	public DataSource mysqlDataSource(DefaultDataSourceCofig dbConfig) {
		DruidDataSource defaultDataSource = new DruidDataSource();
		defaultDataSource.setDriverClassName(dbConfig.getDriverClassName());
		defaultDataSource.setUrl(dbConfig.getUrl());
		defaultDataSource.setUsername(dbConfig.getUsername());
		defaultDataSource.setPassword(dbConfig.getPassword());
		return defaultDataSource;
	}
	
	@Bean(name = SQL_SESSION_FACTORY_NAME)
	@Primary
	public SqlSessionFactory mysqlSessionFactory(@Qualifier("mysqlDataSource") DataSource dataSource) 
	 throws Exception{
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		// 设置映射的mybatis mapper文件
		bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(LOCAL_MAPPER));
		// 设置mybatis映射的bean包
		bean.setTypeAliasesPackage(TYPE_ALIASES_PACKAGE);
		return bean.getObject();  
	}
	
	@Bean(name = "mysqlSessionTemplate")
	@Primary
	public SqlSessionTemplate mysqlSessionTemplate(@Qualifier(SQL_SESSION_FACTORY_NAME) SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
	
	/**
	 * 定义事务管理器
	 * @param dataSource
	 * @return
	 */
	@Bean(name = "mysqlTransactionManager")
	@Primary
	public DataSourceTransactionManager mysqlTransactionManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
	
}
