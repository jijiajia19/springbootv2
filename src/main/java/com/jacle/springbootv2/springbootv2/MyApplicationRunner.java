package com.jacle.springbootv2.springbootv2;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author jacle
 * @version 1.0
 * @description: ApplicationRunner
 * @date 12/15/2021 5:22 PM
 */
@Order(2)
@Component
public class MyApplicationRunner implements ApplicationRunner
{
    @Override
    public void run(ApplicationArguments args) throws Exception
    {
        System.out.println("自动执行了ApplicationRunner方法...");
        System.out.println("显示参数:");
        System.out.println(args.getNonOptionArgs());
        System.out.println(args.getOptionNames());
    }
}
