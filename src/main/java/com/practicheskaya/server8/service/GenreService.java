package com.practicheskaya.server8.service;

import com.practicheskaya.server8.entity.Genre;
import com.practicheskaya.server8.repository.GenreRepo;
import com.practicheskaya.server8.response.BaseResponse;
import com.practicheskaya.server8.response.DataResponse;
import com.practicheskaya.server8.response.ListResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreService {
    private final GenreRepo genreRepo;

    public GenreService(GenreRepo genreRepo) {
        this.genreRepo = genreRepo;
    }

    public ListResponse<Genre> findAll() {
        List<Genre> genres = genreRepo.findAll();
        return ListResponse.success(genres);
    }

    public DataResponse<Genre> findById(Long id) {
        Optional<Genre> genre = genreRepo.findById(id);

        if (genre.isEmpty()) {
            return DataResponse.errorData("Жанр с ID " + id + " не найден");
        }

        return DataResponse.success(genre.get());
    }

    public DataResponse<Genre> save(Genre genre) {
        try {
            Genre savedGenre = genreRepo.save(genre);
            return DataResponse.success("Жанр успешно создан", savedGenre);
        } catch (Exception e) {
            return DataResponse.errorData("Ошибка при создании жанра: " + e.getMessage());
        }
    }

    public DataResponse<Genre> update(Genre genre) {
        if (genre.getId() == null || !genreRepo.existsById(genre.getId())) {
            return DataResponse.errorData("Жанр не найден для обновления");
        }

        try {
            Genre updatedGenre = genreRepo.save(genre);
            return DataResponse.success("Жанр успешно обновлен", updatedGenre);
        } catch (Exception e) {
            return DataResponse.errorData("Ошибка при обновлении жанра: " + e.getMessage());
        }
    }

    public BaseResponse delete(Long id) {
        if (!genreRepo.existsById(id)) {
            return new BaseResponse(false, "Жанр с ID " + id + " не найден");
        }

        try {
            genreRepo.deleteById(id);
            return new BaseResponse(true, "Жанр успешно удален");
        } catch (Exception e) {
            return new BaseResponse(false, "Ошибка при удалении жанра: " + e.getMessage());
        }
    }
}