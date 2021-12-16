package com.jacle.springbootv2.springbootv2;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author jacle
 * @version 1.0
 * @description: 测试基类
 * @date 12/16/2021 3:07 PM
 */

@RunWith(SpringRunner.class)
@TestPropertySource(locations = {"classpath:application-test1.yml"})
@SpringBootTest
public abstract class BaseTest
{
}
