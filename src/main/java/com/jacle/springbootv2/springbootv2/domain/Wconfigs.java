package com.jacle.springbootv2.springbootv2.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.validation.annotation.Validated;

import javax.annotation.PostConstruct;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;

/**
 * @author jacle
 * @version 1.0
 * @description: 直接将配置类型实体类
 * @date 12/16/2021 11:13 AM
 */

//必须配置校验注解
@Validated
@Configuration
@PropertySource(encoding = "UTF-8", ignoreResourceNotFound = true, value = "classpath:application.properties")
@ConfigurationProperties(prefix = "my1")
//配置文件注入后，通过Environment来读取
public class Wconfigs
{

	@NotEmpty(message = "名字不能为空")
	private String name;

	@Max(value = 200,message = "年龄不符合规范")
	private int age;


	public String getName()
	{
		return name;
	}

	@PostConstruct
	public void prt()
	{
		System.out.println("-----------------2||"+this.name);
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
