package com.practicheskaya.server8.controller;

import com.practicheskaya.server8.entity.Genre;
import com.practicheskaya.server8.response.BaseResponse;
import com.practicheskaya.server8.response.DataResponse;
import com.practicheskaya.server8.response.ListResponse;
import com.practicheskaya.server8.service.GenreService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Жанры", description = "Управление жанрами")
@RestController
public class GenreController {
    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping(value = "/genres")
    public ListResponse<Genre> getAllGenres() {
        return genreService.findAll();
    }

    @GetMapping(value = "/genres/{id}")
    public DataResponse<Genre> getGenreById(@PathVariable Long id) {
        return genreService.findById(id);
    }

    @PostMapping(value = "/genres")
    public DataResponse<Genre> createGenre(@RequestBody Genre genre) {
        return genreService.save(genre);
    }

    @PutMapping(value = "/genres")
    public DataResponse<Genre> updateGenre(@RequestBody Genre genre) {
        return genreService.update(genre);
    }

    @DeleteMapping(value = "/genres/{id}")
    public BaseResponse deleteGenre(@PathVariable Long id) {
        return genreService.delete(id);
    }
}