package com.qby.controller;

import com.qby.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author qby
 * @date 2020/6/9 13:19
 */
@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Override
    public String toString() {
        return "BookController{" +
                "bookService=" + bookService +
                '}';
    }
}
