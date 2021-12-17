package com.jacle.springbootv2.springbootv2.mock.service.impl;

import com.jacle.springbootv2.springbootv2.mock.domain.Book;
import com.jacle.springbootv2.springbootv2.mock.service.BookService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * @author Dax
 * @since 14:55  2019-07-23
 */
@Service
public class BookServiceImpl implements BookService
{

    @Override
    public Book queryByTitle(String title) {
        Book book = new Book();
        book.setAuthor("dax");
        book.setPrice(78.56);
        book.setReleaseTime(LocalDate.of(2018, 3, 22));
        book.setTitle(title);
        return book;
    }
}
