package com.jacle.springbootv2.springbootv2.postconstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @description:
 * 			轻量的逻辑可放在Bean的@PostConstruct方法中
 * 			耗时长的逻辑如果放在@PostConstruct方法中，可使用独立线程执行
 * 			初始化操作放在CommandLineRunner或ApplicationRunner的实现组件中1
 * @author jacle
 * @date 12/15/2021 3:49 PM
 * @version 1.0
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE + 1)
public class ComponentTwo
{
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public ComponentTwo()
	{
		this.logger.info("ComponentTwo 初始化完成");
	}

	@PostConstruct
	public void init()
	{
		this.logger.info("ComponentTwo 初始化完成后处理");
	}
}