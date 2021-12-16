package com.jacle.springbootv2.springbootv2;

import com.jacle.springbootv2.springbootv2.domain.Wconfigs;
import com.jacle.springbootv2.springbootv2.utils.PropertiesReaderUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author jacle
 * @version 1.0
 * @description: 非web应用运行程序
 * @date 12/15/2021 3:35 PM
 */

@SpringBootApplication
public class AppStarter
{
	public static void main(String[] args)
	{
		// 返回的是一个ctx，可以通过ctx得到指定的Bean
		ConfigurableApplicationContext ctx = SpringApplication.run(AppStarter.class, args);

		// 通过ctx来获取bean
		PropertiesReaderUtil util = (PropertiesReaderUtil) ctx.getBean("propertiesReaderUtil");

		System.out.println(util.getName() + "," + util.getAge());
		System.out.println("age32:"+util.getAge32());
		System.out.println(util.getProperty("age32"));

		//读取Resource文件
		util.getResourceProperty();
		// 第二种启动方式(web方式)
		// new SpringApplicationBuilder().main(AppStarter
		// .class).web(WebApplicationType.NONE).build(args);


		ApplicationContext context = new AnnotationConfigApplicationContext(Wconfigs.class);
		System.out.println(context);
	}

	@PostConstruct
	public void init()
	{
		// 初始化操作
		System.out.println("--------->>> start from my service init method");
	}

	@PreDestroy
	public void destory()
	{
		System.out.println("destory...");
	}
}
