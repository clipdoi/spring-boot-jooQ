package com.example.springbootjooQ.controller;

import com.example.springbootjooQ.model.tables.pojos.Book;
import com.example.springbootjooQ.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getBooks(){
        return bookService.getBooks();
    }

    @PostMapping("/create")
    public void postBook(@RequestBody Book book){
        bookService.insertBook(book);
    }

    @PutMapping("/update")
    public String updateProduct(@RequestBody Book book) {
        return bookService.updateBook(book);
    }

    @DeleteMapping
    public Integer deleteProduct(@RequestParam int id) {
        return bookService.deleteBook(id);
    }
}