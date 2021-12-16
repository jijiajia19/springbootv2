package com.jacle.springbootv2.springbootv2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jacle
 * @version 1.0
 * @description: 基本接口
 * @date 12/16/2021 4:09 PM
 */
//这里不需要添加@controller注解
@RestController
public class Hello
{
    @GetMapping("/hello")
    public String helo()
    {
        return "你好,hello";
    }
}
