package com.jacle.springbootv2.springbootv2;

import com.jacle.springbootv2.springbootv2.domain.Wconfigs;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author jacle
 * @version 1.0
 * @description: 测试代码
 * @date 12/16/2021 1:14 PM
 */
@SpringBootTest
public class SpringBootTest2
{
    @Autowired
    private Wconfigs wconfigs;

    @Test
    void contextLoads()
    {
    }
}
