package com.jacle.springbootv2.springbootv2.mock.domain;

import java.time.LocalDate;

/**
 * @author Dax
 * @since 10:22 2019-07-23
 */
public class Book
{
	private String title;
	private String author;
	private Double price;
	private LocalDate releaseTime;

	public String getAuthor()
	{
		return author;
	}

	public void setAuthor(String author)
	{
		this.author = author;
	}

	public Double getPrice()
	{
		return price;
	}

	public void setPrice(Double price)
	{
		this.price = price;
	}

	public LocalDate getReleaseTime()
	{
		return releaseTime;
	}

	public void setReleaseTime(LocalDate releaseTime)
	{
		this.releaseTime = releaseTime;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}
}
