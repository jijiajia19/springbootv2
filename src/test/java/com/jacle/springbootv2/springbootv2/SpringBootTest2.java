package com.jacle.springbootv2.springbootv2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author jacle
 * @version 1.0
 * @description: 测试代码
 * @date 12/16/2021 1:14 PM
 */

// @SpringBootTest替代了spring-test中的@ContextConfiguration注解，目的是加载ApplicationContext，启动spring容器。
//需要指定starter，否则出现multiple @SpringBootConfiguration
@SpringBootTest(classes={AppStarter.class})
public class SpringBootTest2 extends BaseTest
{

	@Before
	public void setUp() throws Exception
	{
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void test1()
	{
		System.out.println("test mode unit");
	}

}
