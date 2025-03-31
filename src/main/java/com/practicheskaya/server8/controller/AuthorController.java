package com.practicheskaya.server8.controller;

import com.practicheskaya.server8.entity.Author;
import com.practicheskaya.server8.response.BaseResponse;
import com.practicheskaya.server8.response.DataResponse;
import com.practicheskaya.server8.response.ListResponse;
import com.practicheskaya.server8.service.AuthorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Авторы", description = "Управление авторами")
@RestController
public class AuthorController {
    private final AuthorService authorService;

    // Конструктор для внедрения зависимости
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    // Получить всех авторов
    @GetMapping(value = "/authors")
    public ListResponse<Author> getAllAuthors() {
        return authorService.findAll();
    }

    // Получить автора по ID
    @GetMapping(value = "/authors/{id}")
    public DataResponse<Author> getAuthorById(@PathVariable Long id) {
        return authorService.findById(id);
    }

    // Создать нового автора
    @PostMapping(value = "/authors")
    public DataResponse<Author> createAuthor(@RequestBody Author author) {
        return authorService.save(author);
    }

    // Обновить существующего автора
    @PutMapping(value = "/authors")
    public DataResponse<Author> updateAuthor(@RequestBody Author author) {
        return authorService.update(author);
    }

    // Удалить автора по ID
    @DeleteMapping(value = "/authors/{id}")
    public BaseResponse deleteAuthor(@PathVariable Long id) {
        return authorService.delete(id);
    }

}