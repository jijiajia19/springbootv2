package com.jacle.springbootv2.springbootv2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
		SpringApplication.run(AppStarter.class, args);
		//第二种启动方式(web方式)
//		new SpringApplicationBuilder().main(AppStarter
//				.class).web(WebApplicationType.NONE).build(args);
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
