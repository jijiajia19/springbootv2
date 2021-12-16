package com.jacle.springbootv2.springbootv2.config;

import org.springframework.context.annotation.Configuration;

/**
 * @author jacle
 * @version 1.0
 * @description: JavaConfig的形式代替xml配置文件
 * @date 12/16/2021 2:22 PM
 */
@Configuration
public class Jconfig
{

	//@Bean将方法转换为Bean
    //@Bean默认是单例的
/*	@Bean
	public DataSource dataSource()
	{
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		try
		{
			dataSource.setDriverClass("com.mysql.jdbc.Driver");
			dataSource.setJdbcUrl("jdbc:mysql://192.168.100.25:6660/TXSMS?useUnicode=true&amp;characterEncoding=utf-8");
			dataSource.setUser("root");
			dataSource.setPassword("123456");
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
		return dataSource;
	}

	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource)
	{
		SqlSessionFactory factory = null;
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		bean.setConfigLocation(resolver.getResource("classpath:mybatis.xml"));
		try
		{
			factory = bean.getObject();
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
		return factory;
	}

	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory)
	{
		return new SqlSessionTemplate(sqlSessionFactory);
	}

	@Bean
	public PlatformTransactionManager transactionManager(DataSource dataSource)
	{
		return new DataSourceTransactionManager(dataSource);
	}*/
}
