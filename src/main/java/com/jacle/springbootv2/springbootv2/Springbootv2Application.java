package com.jacle.springbootv2.springbootv2;

import com.jacle.springbootv2.springbootv2.controller.Hello;
import com.jacle.springbootv2.springbootv2.exclude.User2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

//主要通过这个注解实现自动配置
@SpringBootApplication
@ComponentScan(basePackages = "com.jacle.springbootv2.springbootv2", excludeFilters = {
		@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = { Hello.class, User2.class }) })
public class Springbootv2Application
{

	public static void main(String[] args)
	{
		// System.setProperty("spring.devtools.restart.enabled", "false");
		SpringApplication.run(Springbootv2Application.class, args);
	}

}
