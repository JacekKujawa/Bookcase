package com.isa.bookcase.domain;

import com.isa.bookcase.repository.Books;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {

    private final Books books;

    public BooksController(Books books) {
        this.books = books;
    }

    @GetMapping
    public List<Book> importBooks() {
        return books.getBooks();
    }
}


