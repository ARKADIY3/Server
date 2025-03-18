package com.practicheskaya.server8.controller;

import com.practicheskaya.server8.entity.Publisher;
import com.practicheskaya.server8.response.BaseResponse;
import com.practicheskaya.server8.response.DataResponse;
import com.practicheskaya.server8.response.ListResponse;
import com.practicheskaya.server8.service.PublisherService;
import org.springframework.web.bind.annotation.*;

@RestController
public class PublisherController {
    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping(value = "/publishers")
    public ListResponse<Publisher> getAllPublishers() {
        return publisherService.findAll();
    }

    @GetMapping(value = "/publishers/{id}")
    public DataResponse<Publisher> getPublisherById(@PathVariable Long id) {
        return publisherService.findById(id);
    }

    @PostMapping(value = "/publishers")
    public DataResponse<Publisher> createPublisher(@RequestBody Publisher publisher) {
        return publisherService.save(publisher);
    }

    @PutMapping(value = "/publishers")
    public DataResponse<Publisher> updatePublisher(@RequestBody Publisher publisher) {
        return publisherService.update(publisher);
    }

    @DeleteMapping(value = "/publishers/{id}")
    public BaseResponse deletePublisher(@PathVariable Long id) {
        return publisherService.delete(id);
    }
}