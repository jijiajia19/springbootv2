package com.jacle.springbootv2.springbootv2.domain;

import com.jacle.springbootv2.springbootv2.utils.YmlConfigFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.PostConstruct;

/**
 * @author jacle
 * @version 1.0
 * @description: 直接将配置类型实体类
 * @date 12/16/2021 11:13 AM
 */

//配置的类，劲量自己new，属于单实例
@Configuration
@PropertySource(encoding = "UTF-8", ignoreResourceNotFound = true, value = "classpath:application-test2.yml",factory = YmlConfigFactory.class)
@ConfigurationProperties(prefix = "zhbin3.config.wconfigs2")
//配置文件注入后，通过Environment来读取
public class Wconfigs2
{
	private String name;
	private int age;


	public String getName()
	{
		return name;
	}

	@PostConstruct
	public void prt()
	{
		System.out.println("-----------------3||"+this.name);
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

}
