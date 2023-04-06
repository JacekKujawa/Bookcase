package com.isa.bookcase;

import com.isa.bookcase.repository.Books;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookcaseApp
{
    public static void main(String[] args)
    {
       SpringApplication.run(BookcaseApp.class, args);
      //Books books = new Books();
      //System.out.println(books.searchByTitle("a"));
    }

}
