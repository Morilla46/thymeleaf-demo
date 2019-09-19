package com.demo.bookshelf.service;

import com.demo.bookshelf.model.Book;

import java.util.List;

public interface BookService {
    List<Book> selectBookList();
}
