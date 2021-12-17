package com.jacle.springbootv2.springbootv2;

import com.jacle.springbootv2.springbootv2.mock.domain.Book;
import com.jacle.springbootv2.springbootv2.mock.service.BookService;
import com.jacle.springbootv2.springbootv2.mock.service.Myclass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDate;

/**
 * @author jacle
 * @version 1.0
 * @description: mock测试
 * @date 12/17/2021 10:01 AM
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Springbootv2Application.class)
public class MockTest extends BaseTest
{
	// springboot使用mockbean，不依赖sb采用mock
	// 能够替换spring上下文同类型的bean
	// Mock将替换Spring上下文中任何相同类型的现有bean
	@MockBean
	private BookService bookService;

	@Mock
	private BookService bookService2;

	//do when调用真实的方法
	//为测试主体类部分打桩考虑使用SpyBean, 为外部依赖打桩，考虑使用MockBean
	//区分点：是否需要将类完全Mock
	@SpyBean
	private Myclass myclass;

	private String title = "java learning";

	@Autowired
	private WebApplicationContext context;

	@Before
	public void init()
	{
		// BDDMockito 进行打桩处理
		/*
		 * BDDMockito.given(userService.add("王五")).willReturn(9);
		 * BDDMockito.given(userService.add("")).willReturn(0);
		 * BDDMockito.given(userService.add(null)).willThrow(NullPointerException.class)
		 * ;
		 */
		BDDMockito.reset(bookService);

		/*
		 * BDDMockito.given(bookService.queryByTitle("1")).willReturn(getBook(title));
		 * BDDMockito.given(bookService.queryByTitle("ss")).willReturn(getBook(title));
		 * BDDMockito.given(bookService.queryByTitle("s1")).willThrow(
		 * NullPointerException.class);
		 */

		// do/when：包括doThrow(…).when(…) / doReturn(…).when(…) / doAnswer(…).when(…)
		// given/will：包括given(…).willReturn(…) / given(…).willAnswer(…)
		// when/then: 包括when(…).thenReturn(…) / when(…).thenAnswer(…)

		// 通过answer来进行if-else的书写
		BDDMockito.when(bookService.queryByTitle(BDDMockito.anyString())).thenAnswer((Answer<Book>) invocationOnMock ->
		{
			Book b = new Book();
			b.setTitle(invocationOnMock.getArgument(0, String.class));
			return b;
		});
	}

	@Test
	public void test1()
	{
		// 利用mockBean测试服务
		// Assertions.assertThat(bookService.queryByTitle("ss").getTitle()).isEqualTo(title);
		System.out.println(bookService.queryByTitle("ss").getTitle());
		// 验证mockbean注解是否改变上下文中所有对象

		BookService bs = context.getBean(BookService.class);
		System.out.println(bs.queryByTitle("1").getTitle());
	}

	// mockito直接进行mock接口对象
	@Test
	public void test2()
	{
		// 通过直接mock可以进行普通的service类测试
		// 鼓励使用mock注解来处理,提示错误明显
		BookService bookService = Mockito.mock(BookService.class);
		Mockito.when(bookService.queryByTitle("1")).thenReturn(getBook(title));
		Mockito.when(bookService.queryByTitle("2")).thenReturn(getBook(title));

		Book returnB = bookService.queryByTitle("2");

		Assert.assertEquals("java learning", returnB.getTitle());

		// 验证bookService的方法被调用
		//验证调用次数，以确保集成测试中，没有遗漏
		Mockito.verify(bookService).queryByTitle("2");
		Mockito.verify(bookService,Mockito.times(1)).queryByTitle(Mockito.anyString());
	}

	@Test
	public void test3()
	{
		Mockito.when(bookService2.queryByTitle("1")).thenReturn(getBook(title));
		Mockito.when(bookService2.queryByTitle("2")).thenReturn(getBook(title));

		Book returnB = bookService2.queryByTitle("2");

		Assert.assertEquals("java learning", returnB.getTitle());
	}


	@Test
	public void test4()
	{
//		Mockito.doReturn("doReturn(...)when(...)").when(myclass).methodToBeTested();
		Mockito.when(myclass.methodToBeTested()).thenReturn("doReturn(...)when(...)");
		String str = myclass.methodToBeTested();
		System.out.println(str);
	}

	public Book getBook(String title)
	{
		Book book = new Book();
		book.setAuthor("dax");
		book.setPrice(78.56);
		book.setReleaseTime(LocalDate.of(2018, 3, 22));
		book.setTitle(title);

		return book;
	}
}
