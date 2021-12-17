package com.jacle.springbootv2.springbootv2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author jacle
 * @version 1.0
 * @description: TODO
 * @date 12/16/2021 5:35 PM
 */
@SpringBootTest(classes = Springbootv2Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
// 打开mock测试
@AutoConfigureMockMvc
public class SpringBootTest3Mock extends BaseTest
{
	protected static Logger logger = LoggerFactory.getLogger(SpringBootTest3Mock.class);

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext context;

	@Before
	public void setupMockMvc() throws Exception
	{
		// 构建mockMVC
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Before
	public void testBefore()
	{
		logger.info("测试前，打印...");
	}

	@After
	public void testAfter()
	{
		logger.info("测试后，打印...");
	}

	@Test(timeout = 1000)
	public void apiTest() throws Exception
	{
		//mock进行测试的时候，前面的contextPrefix不需要添加
		String url = "/hello";
		String expectResult = "Hello，greetings from sprint-boot2-autotest";

		System.out.println("--------------------");
		mockMvc.perform(MockMvcRequestBuilders.get(url).param("title", "title"))
				// 期望：200成功状态码
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print());
				// 期望：返回结果数据
//				.andExpect(MockMvcResultMatchers.content().string(expectResult)).andReturn();

//		int status = mvcResult.getResponse().getStatus();
//		logger.info("返回状态码status=" + status);
//
//		String content = mvcResult.getResponse().getContentAsString();
//		logger.info("返回结果数据content=" + content);
	}

}
