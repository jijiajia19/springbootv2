package com.jacle.springbootv2.springbootv2.domain;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author jacle
 * @version 1.0
 * @description: 某个类注入之后立刻执行某个操作
 * @date 12/15/2021 4:45 PM
 */
@Component
public class Domain implements InitializingBean
{
    //读取不到就会显示unkown,指定标定的数值
    @Value("${type:unkown}")
    private String typename;

    @Value("${age:unkown}")
    private String age;

    @Override
    public void afterPropertiesSet() throws Exception
    {
        System.out.println(this.getClass().getName()+"bean注入完成,"+typename+","+age);
    }
}
