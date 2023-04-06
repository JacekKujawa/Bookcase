package com.isa.bookcase.domain;


import com.isa.bookcase.repository.Books;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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


}


