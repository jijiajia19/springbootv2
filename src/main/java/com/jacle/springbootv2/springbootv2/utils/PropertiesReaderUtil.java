package com.jacle.springbootv2.springbootv2.utils;

import com.jacle.springbootv2.springbootv2.domain.Wconfigs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

/**
 * @author jacle
 * @version 1.0
 * @description: 读取配置文件的工具 1.通过@value来进行读取,如果防止配置被删除，需要指定默认值
 *               注解@PropertySource依赖指定解析的具体文件，只会加载properties文件
 *               简单对象@value，复杂对象使用@configurationProperties
 *
 *               2.通过Environment来读取配置文件
 *
 *               3.将配置文件的实体信息，映射到指定的实体类
 *
 * @date 12/15/2021 3:44 PM
 *
 *       Spring4 以后，官方推荐我们使用Java Config来代替applicationContext.xml，声明将Bean交给容器管理
 *
 */
@Configuration
@PropertySource(value = "classpath:other.properties", encoding = "gbk")
@PropertySource(value = "classpath:application-test1.yml", encoding = "gbk", factory = YmlConfigFactory.class)
// 通过Environment来读取配置文件
public class PropertiesReaderUtil
{
	@Autowired
	private Environment environment;

	// @value可以直接读取一个配置文件，压缩为Resource对象
	@Value("classpath:application.properties")
	private Resource resourceFile;

	// 构造方法输入，可以设置实体类为final类型，直接变量注入是不可能实现这样的方式
	// private final Wconfigs webConfigs;

	@Autowired
	private Wconfigs wconfigs;

	// spring从4.0开始推荐使用构造方法注入、set方法注入，前者是强制注入，后者是选择注入
	@Autowired
	public PropertiesReaderUtil()
	{
	}

	@Value("${zhbin1.config.wconfigs.name}")
	private String name;

	@Value("${zhbin1.config.wconfigs.age}")
	private int age;

	@Value("${age32}")
	private int age32;

	public String getName()
	{
		return name;
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

	public int getAge32()
	{
		return age32;
	}

	public String getProperty(String key)
	{
		return environment.getProperty(key);
	}

	public void getResourceProperty()
	{
		if (resourceFile.exists())
		{
			System.out.println(resourceFile.getFilename());
			System.out.println(wconfigs);
			System.out.println(wconfigs.getName());
			System.out.println("-->zhbin.config.web-configs.name:" + this.getName());
		}
	}

}
