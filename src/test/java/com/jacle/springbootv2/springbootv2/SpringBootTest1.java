package com.jacle.springbootv2.springbootv2;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.net.URL;

/**
 * @author jacle
 * @version 1.0
 * @description: java测试分为： 1. 普通Java测试，比如配置参数加载，静态方法返回值等 2. 普通Web接口测试 3.
 *               业务服务层代码测试 4. 使用MockMvc测试接口
 * @date 12/16/2021 3:44 PM
 */

// 使用随机接口来进行定位
@SpringBootTest(classes = Springbootv2Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringBootTest1 extends BaseTest
{
	protected static Logger logger = LoggerFactory.getLogger(SpringBootTest1.class);

	/**
	 * @LocalServerPort 提供了 @Value("${local.server.port}") 的代替
	 */
	@LocalServerPort
	private int port;

	private URL base;

	@Autowired
	private TestRestTemplate restTemplate;

	@Before
	public void setUp() throws Exception
	{
		String url = String.format("http://localhost:%d/", port);
		logger.info("随机自动分配端口后的整体请求头--->>> " + url);
		this.base = new URL(url);
	}

	/**
	 * 向"/hello"地址发送请求，并打印返回结果
	 *
	 * @throws Exception
	 */
	@Test
	public void testUrlApi() throws Exception
	{
		String url = this.base.toString() + "/hello";
		logger.info("待测试接口地址：url=" + url);
		ResponseEntity<String> response = this.restTemplate.getForEntity(url, String.class, "");
		String result = response.getBody();
		logger.info("返回结果：result=" + result);
		boolean expected = false;
		if (result != null && result.contains("sprint-boot2-autotest"))
		{
			expected = true;
		}
		TestCase.assertEquals(true, expected);
	}

}
