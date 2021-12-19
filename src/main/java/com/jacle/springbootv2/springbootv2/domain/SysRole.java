package com.jacle.springbootv2.springbootv2.domain;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

public class SysRole
{
	private Integer id;
	@NotEmpty(message = "name不能为空")
	private String name;

	//对象进行验证，要加上此标记
	//此验证是为了在request进行validate
	@Valid
	private User user;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
}