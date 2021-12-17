package com.jacle.springbootv2.springbootv2.mock.service;

public class Myclass
{
	public String methodToBeTested()
	{
		return function();
	}

	public String function()
	{
		throw new NullPointerException();
	}
}