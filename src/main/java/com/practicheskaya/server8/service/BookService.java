package com.practicheskaya.server8.service;

import com.practicheskaya.server8.entity.Book;
import com.practicheskaya.server8.repository.BookRepo;
import com.practicheskaya.server8.response.BaseResponse;
import com.practicheskaya.server8.response.DataResponse;
import com.practicheskaya.server8.response.ListResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepo bookRepo;

    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public ListResponse<Book> findAll() {
        List<Book> books = bookRepo.findAll();
        return ListResponse.success(books);
    }

    public DataResponse<Book> findById(Long id) {
        Optional<Book> book = bookRepo.findById(id);

        if (book.isEmpty()) {
            return DataResponse.errorData("Книга с ID " + id + " не найдена");
        }

        return DataResponse.success(book.get());
    }

    public DataResponse<Book> save(Book book) {
        try {
            Book savedBook = bookRepo.save(book);
            return DataResponse.success("Книга успешно создана", savedBook);
        } catch (Exception e) {
            return DataResponse.errorData("Ошибка при создании книги: " + e.getMessage());
        }
    }

    public DataResponse<Book> update(Book book) {
        if (book.getId() == null || !bookRepo.existsById(book.getId())) {
            return DataResponse.errorData("Книга не найдена для обновления");
        }

        try {
            Book updatedBook = bookRepo.save(book);
            return DataResponse.success("Книга успешно обновлена", updatedBook);
        } catch (Exception e) {
            return DataResponse.errorData("Ошибка при обновлении книги: " + e.getMessage());
        }
    }

    public BaseResponse delete(Long id) {
        if (!bookRepo.existsById(id)) {
            return new BaseResponse(false, "Книга с ID " + id + " не найдена");
        }

        try {
            bookRepo.deleteById(id);
            return new BaseResponse(true, "Книга успешно удалена");
        } catch (Exception e) {
            return new BaseResponse(false, "Ошибка при удалении книги: " + e.getMessage());
        }
    }
}