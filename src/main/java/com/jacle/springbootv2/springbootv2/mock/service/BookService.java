package com.jacle.springbootv2.springbootv2.mock.service;

import com.jacle.springbootv2.springbootv2.mock.domain.Book;

/**
 * The interface Book service.
 *
 * @author Dax
 * @since 14 :54  2019-07-23
 */
public interface BookService {

    /**
     * Query by title book.
     *
     * @param title the title
     * @return the book
     */
    Book queryByTitle(String title);

}
