package com.qby.service;

import com.qby.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.inject.Inject;

/**
 * @author qby
 * @date 2020/6/9 13:20
 */
@Service
public class BookService {


//    @Qualifier("bookDao")
//    @Autowired(required = false)
//    @Resource(name="bookDao2")
    @Autowired(required = false)
    private BookDao bookDao;

    public void print() {
        System.out.println(bookDao);
    }

    @Override
    public String toString() {
        return "BookService{" +
                "bookDao=" + bookDao +
                '}';
    }
}
