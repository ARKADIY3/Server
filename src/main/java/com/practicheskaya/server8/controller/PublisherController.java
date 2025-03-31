package com.practicheskaya.server8.controller;

import com.practicheskaya.server8.entity.Publisher;
import com.practicheskaya.server8.response.BaseResponse;
import com.practicheskaya.server8.response.DataResponse;
import com.practicheskaya.server8.response.ListResponse;
import com.practicheskaya.server8.service.PublisherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Издатели", description = "Управление издателями")
@RestController
public class PublisherController {
    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @Operation(summary = "Получить всех издателей", description = "Возвращает список всех издателей")
    @GetMapping(value = "/publishers")
    public ListResponse<Publisher> getAllPublishers() {
        return publisherService.findAll();
    }

    @Operation(summary = "Получить издателя по ID", description = "Возвращает информацию о издателе по его уникальному идентификатору")
    @GetMapping(value = "/publishers/{id}")
    public DataResponse<Publisher> getPublisherById(@PathVariable Long id) {
        return publisherService.findById(id);
    }

    @Operation(summary = "Создать нового издателя", description = "Позволяет создать нового издателя")
    @PostMapping(value = "/publishers")
    public DataResponse<Publisher> createPublisher(@RequestBody Publisher publisher) {
        return publisherService.save(publisher);
    }

    @Operation(summary = "Обновить существующего издателя", description = "Позволяет обновить информацию о издателе")
    @PutMapping(value = "/publishers")
    public DataResponse<Publisher> updatePublisher(@RequestBody Publisher publisher) {
        return publisherService.update(publisher);
    }

    @Operation(summary = "Удалить издателя", description = "Удаляет издателя по его уникальному идентификатору")
    @DeleteMapping(value = "/publishers/{id}")
    public BaseResponse deletePublisher(@PathVariable Long id) {
        return publisherService.delete(id);
    }
}