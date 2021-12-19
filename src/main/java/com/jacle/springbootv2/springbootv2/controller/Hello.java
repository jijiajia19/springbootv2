package com.jacle.springbootv2.springbootv2.controller;

import com.jacle.springbootv2.springbootv2.domain.SysRole;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.util.List;

/**
 * @author jacle
 * @version 1.0
 * @description: 基本接口
 * @date 12/16/2021 4:09 PM
 */
// 这里不需要添加@controller注解
@RestController
public class Hello
{
	@GetMapping("/hello")
	public String helo()
	{
		return "你好,hello,修改之后查看是否热部署成功!--livereload added test second times";
	}

	@RequestMapping("/hellovalidate")
	//为了保证验证，需要在参数前加入valid注解
	public Object index(@Valid SysRole role, BindingResult bindingResult)
	{
		List<ObjectError> error = null;
		// 返回boolean 是为了验证@Validated后面bean 里是否有不符合注解条件的错误信息
		if (bindingResult.hasErrors())
		{
			// 获得所有错误信息返回list集合
			error = bindingResult.getAllErrors();
			for (ObjectError o : error)
			{
				// 获得不符合要求的message
				return o.getDefaultMessage();
			}

		}
		return null;
	}


	@PostConstruct
	public void prt()
	{
		System.out.println("---------->load class "+this.getClass().getName());
	}
}
