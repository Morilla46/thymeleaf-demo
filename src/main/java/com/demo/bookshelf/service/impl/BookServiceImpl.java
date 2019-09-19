package com.demo.bookshelf.service.impl;

import com.demo.bookshelf.model.Book;
import com.demo.bookshelf.service.BookService;
import com.demo.bookshelf.utils.JsonUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Override
    public List<Book> selectBookList() {
        List<Book> books;
        try{
            books = JsonUtils.getArrayFromJson("demodata/books.json", Book.class);
        }catch (Exception e){
            books = null;
        }
        return books;
    }
}
