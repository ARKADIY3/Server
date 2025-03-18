package com.practicheskaya.server8.controller;

import com.practicheskaya.server8.entity.Book;
import com.practicheskaya.server8.response.BaseResponse;
import com.practicheskaya.server8.response.DataResponse;
import com.practicheskaya.server8.response.ListResponse;
import com.practicheskaya.server8.service.BookService;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = "/books")
    public ListResponse<Book> getAllBooks() {
        return bookService.findAll();
    }

    @GetMapping(value = "/books/{id}")
    public DataResponse<Book> getBookById(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @PostMapping(value = "/books")
    public DataResponse<Book> createBook(@RequestBody Book book) {
        return bookService.save(book);
    }

    @PutMapping(value = "/books")
    public DataResponse<Book> updateBook(@RequestBody Book book) {
        return bookService.update(book);
    }

    @DeleteMapping(value = "/books/{id}")
    public BaseResponse deleteBook(@PathVariable Long id) {
        return bookService.delete(id);
    }
}