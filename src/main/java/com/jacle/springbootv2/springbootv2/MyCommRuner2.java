package com.jacle.springbootv2.springbootv2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author jacle
 * @version 1.0
 * @description:
 *      未封装参数，容器完成之后自动执行业务逻辑
 *      可以定义多个runner，指定顺序
 * @date 12/15/2021 5:14 PM
 */

@Order(2)
@Component
public class MyCommRuner2 implements CommandLineRunner
{
    //容器初始化加载完之后，自动执行run方法
    @Override
    public void run(String... args) throws Exception
    {
        System.out.println("自动执行了commandlineRunner方法...2");
    }
}
