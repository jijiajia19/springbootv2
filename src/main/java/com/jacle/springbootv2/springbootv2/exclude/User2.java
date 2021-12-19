package com.jacle.springbootv2.springbootv2.exclude;

import com.jacle.springbootv2.springbootv2.domain.SysRole;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Component
public class User2
{
	private Integer id;

	@NotEmpty(message = "name不能为空")
	private String username;

	@NotEmpty(message = "password不能为空")
	private String password;
	// @NotNull Integer类型用notnull注解

	private List<SysRole> roles;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public List<SysRole> getRoles()
	{
		return roles;
	}

	public void setRoles(List<SysRole> roles)
	{
		this.roles = roles;
	}

	@PostConstruct
	public void prt()
	{
		System.out.println("---------->load class " + this.getClass().getName());
	}

}