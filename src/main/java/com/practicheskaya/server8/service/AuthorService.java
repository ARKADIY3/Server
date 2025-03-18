package com.practicheskaya.server8.service;

import com.practicheskaya.server8.entity.Author;
import com.practicheskaya.server8.repository.AuthorRepo;
import com.practicheskaya.server8.response.BaseResponse;
import com.practicheskaya.server8.response.DataResponse;
import com.practicheskaya.server8.response.ListResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    private final AuthorRepo authorRepo;

    // Конструктор для внедрения зависимости
    public AuthorService(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    // Получить все записи из базы данных
    public ListResponse<Author> findAll() {
        List<Author> authors = authorRepo.findAll();
        return ListResponse.success(authors);
    }

    // Получить запись по ID
    public DataResponse<Author> findById(Long id) {
        Optional<Author> author = authorRepo.findById(id);

        // Обработка случая, когда автор не найден
        if (author.isEmpty()) {
            return DataResponse.errorData("Автор с ID " + id + " не найден");
        }

        return DataResponse.success(author.get());
    }

    // Сохранить объект в базу данных
    public DataResponse<Author> save(Author author) {
        try {
            Author savedAuthor = authorRepo.save(author);
            return DataResponse.success("Автор успешно создан", savedAuthor);
        } catch (Exception e) {
            return DataResponse.errorData("Ошибка при создании автора: " + e.getMessage());
        }
    }

    // Обновить запись в базе данных
    public DataResponse<Author> update(Author author) {
        // Проверяем, существует ли автор перед обновлением
        if (author.getId() == null || !authorRepo.existsById(author.getId())) {
            return DataResponse.errorData("Автор не найден для обновления");
        }

        try {
            Author updatedAuthor = authorRepo.save(author);
            return DataResponse.success("Автор успешно обновлен", updatedAuthor);
        } catch (Exception e) {
            return DataResponse.errorData("Ошибка при обновлении автора: " + e.getMessage());
        }
    }

    // Удаление автора по ID
    public BaseResponse delete(Long id) {
        if (!authorRepo.existsById(id)) {
            return new BaseResponse(false, "Автор с ID " + id + " не найден");
        }

        try {
            authorRepo.deleteById(id);
            return new BaseResponse(true, "Автор успешно удален");
        } catch (Exception e) {
            return new BaseResponse(false, "Ошибка при удалении автора: " + e.getMessage());
        }
    }
}