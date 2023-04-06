package com.isa.bookcase.domain;

import com.isa.bookcase.repository.Books;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

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
    @GetMapping("/book/{title}")
    public String searchBooksByTitle(@PathVariable String title, Model model) {
        List<Book> matchingBooks = books.searchByTitle(title);
        model.addAttribute("matchingBooks", matchingBooks);
        return "book-search";
    }


}


