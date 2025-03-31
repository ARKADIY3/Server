package com.practicheskaya.server8.controller;

import com.practicheskaya.server8.entity.Book;
import com.practicheskaya.server8.response.BaseResponse;
import com.practicheskaya.server8.response.DataResponse;
import com.practicheskaya.server8.response.ListResponse;
import com.practicheskaya.server8.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Книги", description = "Управление книгами")
@RestController
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @Operation(summary = "Получить все книги", description = "Возвращает список всех книг")
    @GetMapping(value = "/books")
    public ListResponse<Book> getAllBooks() {
        return bookService.findAll();
    }

    @Operation(summary = "Получить книгу по ID", description = "Возвращает информацию о книге по её уникальному идентификатору")
    @GetMapping(value = "/books/{id}")
    public DataResponse<Book> getBookById(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @Operation(summary = "Создать новую книгу", description = "Позволяет создать новую книгу")
    @PostMapping(value = "/books")
    public DataResponse<Book> createBook(@RequestBody Book book) {
        return bookService.save(book);
    }

    @Operation(summary = "Обновить существующую книгу", description = "Позволяет обновить информацию о книге")
    @PutMapping(value = "/books")
    public DataResponse<Book> updateBook(@RequestBody Book book) {
        return bookService.update(book);
    }

    @Operation(summary = "Удалить книгу", description = "Удаляет книгу по её уникальному идентификатору")
    @DeleteMapping(value = "/books/{id}")
    public BaseResponse deleteBook(@PathVariable Long id) {
        return bookService.delete(id);
    }
}