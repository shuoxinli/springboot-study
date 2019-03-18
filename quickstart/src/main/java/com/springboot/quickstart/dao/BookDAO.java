package com.springboot.quickstart.dao;

import com.springboot.quickstart.entity.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 图书的dao类
 */
@Component
public class BookDAO {
    public List<Book> getBooks(){
        List<Book> books= new ArrayList<>();
        books.add(new Book(1,"Spring Boot实战",88.7));
        books.add(new Book(2,"Spring Boot实战",88.7));
        books.add(new Book(3,"Spring Boot实战",88.7));
        return books;
    }

}
