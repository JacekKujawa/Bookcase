package com.isa.bookcase.domain;

import com.isa.bookcase.repository.Books;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/book/search")
    public String showBookSearchForm() {
        return "book-search";
    }

    @GetMapping("/book/search-results")
    public String searchBooksByTitle(@RequestParam(name = "title", required = false) String title, Model model) {
        if (title.isEmpty()) {
            return "book-search";
        }
        List<Book> matchingBooks = books.searchByTitle(title);
        if (!matchingBooks.isEmpty()) {
            model.addAttribute("matchingBooks", matchingBooks);
        }
        return "book-search";
    }
}


