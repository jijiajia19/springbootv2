package com.jacle.springbootv2.springbootv2.listener;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;

/**
 * @author jacle
 * @version 1.0
 * @description: applicationListener容器监听器
 * @date 12/15/2021 5:44 PM
 */
public class MyApplicationListener implements ApplicationListener
{
	@Override
	public void onApplicationEvent(ApplicationEvent event)
	{
		if (event instanceof ApplicationStartingEvent)
		{
			System.out.println("1111");
		}
		if (event instanceof ApplicationEnvironmentPreparedEvent)
		{
			System.out.println("环境初始化！！！");
		} else if (event instanceof ApplicationPreparedEvent)
		{
			System.out.println("初始化完成！！！");
		} else if (event instanceof ContextRefreshedEvent)
		{
			System.out.println("应用刷新！！");
		} else if (event instanceof ApplicationReadyEvent)
		{
			System.out.println("项目启动完成！！");
		} else if (event instanceof ContextStartedEvent)
		{
			System.out.println("应用启动！！");
		} else if (event instanceof ContextStoppedEvent)
		{
			System.out.println("项目中止！！");
		} else if (event instanceof ContextClosedEvent)
		{
			System.out.println("应用关闭！！");
		}

	}
}
