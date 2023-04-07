package com.isa.bookcase.domain.controller;

import com.isa.bookcase.domain.Book;
import com.isa.bookcase.repository.Books;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/books")
public class BooksController {

    private final Books books;

    public BooksController(Books books) {
        this.books = books;
    }

    @GetMapping
    public String displayBooks(Model model) {
        List<Book> booksList = books.getBooks();
        model.addAttribute("books", booksList);
        return "books";
    }

    @GetMapping("/book-for-today")
    public String displayBookForDay(Model model) {
        Book book = books.getBookForToday();
        model.addAttribute("book", book);
        return "book";
    }

//    @GetMapping("/book/search")
//    public String showBookSearchForm() {
//        return "book-search";
//    }

    @GetMapping("/book/search")
    public String searchBooksByTitle(@RequestParam(name = "title", required = false) String title, Model model) {
        if (Objects.isNull(title)) {
            return "book-search";
        }
        List<Book> matchingBooks = books.searchByTitle(title);
        if (!matchingBooks.isEmpty()) {
            model.addAttribute("matchingBooks", matchingBooks);
        }
        return "book-search";
    }
}


