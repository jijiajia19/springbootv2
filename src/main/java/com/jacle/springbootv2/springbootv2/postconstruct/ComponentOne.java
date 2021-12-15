package com.jacle.springbootv2.springbootv2.postconstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ComponentOne
{
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public ComponentOne()
	{
		this.logger.info("ComponentOne 初始化完成");
	}

	@PostConstruct
	public void init()
	{
		this.logger.info("ComponentOne 模拟耗时逻辑开始");
		try
		{
			// 这里休眠5秒模拟耗时逻辑
			Thread.sleep(1000 * 5);
		} catch (InterruptedException e)
		{
			logger.info("模拟逻辑耗时失败", e);
		}
		this.logger.info("ComponentOne 模拟耗时逻辑完成");
	}
}