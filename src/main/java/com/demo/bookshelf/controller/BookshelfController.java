package com.demo.bookshelf.controller;

import com.demo.bookshelf.model.Book;
import com.demo.bookshelf.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.List;

@Controller
class BookshelfController {
    @Autowired BookService bookService;

    @GetMapping("/")
    String index(Model model) {
        List<Book> books = bookService.selectBookList();
        model.addAttribute("now", LocalDateTime.now());
        model.addAttribute("project","Demo Project");
        model.addAttribute("books",books);
        return "index";
    }

}